package com.codegym.cinema.controller;

import com.codegym.cinema.entity.Account;
import com.codegym.cinema.entity.User;
import com.codegym.cinema.jwt.JwtUtils;
import com.codegym.cinema.payload.request.*;
import com.codegym.cinema.payload.response.JwtResponse;
import com.codegym.cinema.payload.response.MessageResponse;
import com.codegym.cinema.service.UserService;
import com.codegym.cinema.service.impl.AccountServiceImpl;
import com.codegym.cinema.service.impl.UserDetailsServiceImpl;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class SecurityController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AccountServiceImpl accountService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${google.clientId}")
    String googleClientId;

    @Value("${secretPsw}")
    String secretPsw;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                            loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = userDetailsService
                    .loadUserByUsername(authentication.getName());
            String jwtToken = jwtUtils.generateToken(userDetails);
            User user = userService.findByUsername(loginRequest.getUsername());
            return ResponseEntity.ok(new JwtResponse(jwtToken, user, userDetails.getAuthorities()));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/send-verification-email")
    public ResponseEntity<Object> reset(@RequestBody ForgotPasswordRequest forgotPasswordRequest) throws MessagingException, UnsupportedEncodingException {
        Account account = null;
        if (userService.findByEmail(forgotPasswordRequest.getEmail()) != null) {
            User user = userService.findByEmail(forgotPasswordRequest.getEmail());
            account = accountService.findByUsernameToResetPassword(user.getAccount().getUsername());
        }
        if(account!=null) {
            accountService.addVerifyCode(account.getUsername());
            return ResponseEntity.ok(new MessageResponse("Đã gửi email xác nhận"));
        }
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Tài khoản không tồn tại"));
    }

    @PostMapping("/check-verification-code")
    public ResponseEntity<Object> checkCode(@RequestBody CheckVerificationRequest checkVerificationRequest) throws MessagingException, UnsupportedEncodingException {
        Account account = accountService.findAccountByVerificationCode(checkVerificationRequest.getVerificationCode());
        if (account == null) return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Sai mã xác nhận"));
        return ResponseEntity.ok(new MessageResponse("Mã xác nhận hợp lệ"));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Object> doResetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) throws MessagingException, UnsupportedEncodingException {
        Account account = accountService.findAccountByVerificationCode(resetPasswordRequest.getVerificationCode());
        if (account == null) return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Sai mã xác nhận"));

        accountService.updatePassword(bCryptPasswordEncoder.encode(resetPasswordRequest.getConfirmPassword()), account.getUsername());
        return ResponseEntity.ok(new MessageResponse("ĐỔi mật khẩu thành công"));
    }

    @PostMapping("/login/google")
    public ResponseEntity<?> loginGoogle(@RequestBody TokenSocialRequest tokenSocialRequest) throws IOException {
        final NetHttpTransport netHttpTransport = new NetHttpTransport();
        final JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();
        GoogleIdTokenVerifier.Builder builder =
                new GoogleIdTokenVerifier.Builder(netHttpTransport, jacksonFactory)
                        .setAudience(Collections.singletonList(googleClientId));
        final GoogleIdToken googleIdToken = GoogleIdToken.parse(builder.getJsonFactory(), tokenSocialRequest.getToken());
        final GoogleIdToken.Payload payload = googleIdToken.getPayload();

        User user = userService.findByEmail(payload.getEmail());
        if (user == null) {
            user = new User();
            user.setName(payload.get("name").toString());
            user.setAvatarUrl(payload.get("picture").toString());
            user.setEmail(payload.get("email").toString());

            Account account = new Account();
            account.setUsername(payload.get("email").toString());
            account.setProvider("GOOGLE");
            return setDefaultPassword(tokenSocialRequest, user, account);
        }
        return getResponseSocialLogin(user);
    }

    @PostMapping("/login/facebook")
    public ResponseEntity<?> facebook(@RequestBody TokenSocialRequest tokenSocialRequest) {
        Facebook facebook = new FacebookTemplate(tokenSocialRequest.getToken());
        final String[] fields = {"email", "name"};
        org.springframework.social.facebook.api.User userFacebook = facebook.fetchObject("me", org.springframework.social.facebook.api.User.class, fields);


        User user = userService.findByEmail(userFacebook.getEmail());
        if (user == null) {
            String urlImg = facebook.getBaseGraphApiUrl() + userFacebook.getId() + "/picture";

            user = new User();
            user.setName(userFacebook.getName());
            user.setAvatarUrl(urlImg);
            user.setEmail(userFacebook.getEmail());

            Account account = new Account();
            account.setUsername(userFacebook.getEmail());
            account.setProvider("FACEBOOK");
            return setDefaultPassword(tokenSocialRequest, user, account);
        }
        return getResponseSocialLogin(user);
    }

    private ResponseEntity<?> setDefaultPassword(@RequestBody TokenSocialRequest tokenSocialRequest, User user, Account account) {
        account.setPassword(bCryptPasswordEncoder.encode(secretPsw));
        account.setIsEnable(true);

        user.setAccount(account);

        accountService.saveSocialAccount(account);
        userService.saveSocialUser(user);

        UserDetails userDetails = userDetailsService.loadUserByUsername(account.getUsername());
        JwtResponse jwtResponse = new JwtResponse(tokenSocialRequest.getToken(), user, userDetails.getAuthorities());
        return ResponseEntity.ok(jwtResponse);
    }

    private ResponseEntity<?> getResponseSocialLogin(User user) {
        Account account = user.getAccount();
        LoginRequest loginRequest = new LoginRequest(account.getUsername(), account.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        String jwtToken = jwtUtils.generateToken(userDetails);
        JwtResponse jwtResponse = new JwtResponse(jwtToken, user, userDetails.getAuthorities());
        return ResponseEntity.ok(jwtResponse);
    }

    @GetMapping("/admin/test")
    private ResponseEntity<?> adminTest(){
        return ResponseEntity.ok(new MessageResponse("ok"));
    }
}
