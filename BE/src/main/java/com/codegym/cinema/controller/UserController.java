package com.codegym.cinema.controller;

import com.codegym.cinema.dto.UserDTO;
import com.codegym.cinema.entity.Account;
import com.codegym.cinema.entity.User;
import com.codegym.cinema.payload.response.MessageResponse;
import com.codegym.cinema.service.AccountRoleService;
import com.codegym.cinema.service.AccountService;
import com.codegym.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRoleService accountRoleService;

    @PostMapping(value = "/register")
    public ResponseEntity<?> createUser(@Validated @RequestBody UserDTO userDTO, BindingResult bindingResult) throws UnsupportedEncodingException, MessagingException {
        System.out.println(1111);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.NOT_ACCEPTABLE);
        }
        try {
            Map<String, String> listError = new HashMap<>();
            if (userService.findUserByUsername(userDTO.getUsername()) != null) {
                listError.put("existAccount", "Tên tài khoản đã tồn tại. Vui lòng nhập tên tài khoản khác.");
            }
            if (userService.findUserByIdCard(userDTO.getIdCard()) != null) {
                listError.put("existIdCard", "Số CMND đã tồn tại. Vui lòng nhập số CMND khác.");
            }
            if (userService.findByEmail(userDTO.getEmail()) != null) {
                listError.put("existEmail", "Email đã tồn tại. Vui lòng nhập số email khác.");
            }
            if (!listError.isEmpty()) {
                return ResponseEntity.badRequest().body(listError);
            }
            userService.createUser(userDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/verify-account")
    public ResponseEntity<Object> checkCode(@RequestParam String code){
        Account account = accountService.findAccountByVerificationCodeToActiveAccount(code);
        if (account == null){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("account not found"));
        }
        accountService.activeAccount(account.getUsername());
        return ResponseEntity.ok(new MessageResponse("actived"));
    }


    @GetMapping("/user/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
        User user = userService.findUserByUsername(username);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
