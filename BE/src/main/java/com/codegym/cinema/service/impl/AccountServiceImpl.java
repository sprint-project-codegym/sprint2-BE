package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.Account;
import com.codegym.cinema.repository.AccountRepository;
import com.codegym.cinema.repository.AccountRoleRepository;
import com.codegym.cinema.repository.UserRepository;
import com.codegym.cinema.service.AccountService;
import com.codegym.cinema.service.UserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountRoleRepository accountRoleRepository;

    @Autowired
    UserRepository userService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void updatePassword(String password, String username) {
        accountRepository.updatePassword(password,username);
        deleteVerifyCode(username);
    }

    @Override
    public Account findAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public Account findByUsernameToResetPassword(String username) {
        return accountRepository.findByUsernameToResetPassword(username);
    }

    @Override
    public void addVerifyCode(String username) throws MessagingException {
        String code = new Random().nextInt(900000) + 100000 + "";
        accountRepository.addVerifyCode(code, username);
        Account account = findAccountByVerificationCode(code);
        sendMailToResetPassword(account.getUser().getEmail(),code);
    }

    @Override
    public void sendMailToResetPassword(String email, String code) throws MessagingException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Email lấy lại mật khẩu từ Cinema A03");
        message.setText("Chào bạn!\n"
                + "TRANG Cinema A03 gửi mã code OTP bên dưới để đổi lại mật khẩu.\n"
                + "Mã CODE bao gồm 6 số : " + code + "\n\n"
                + "Thanks and regards!");
        this.javaMailSender.send(message);
    }

    @Override
    public Account findAccountByVerificationCode(String code) {
        return accountRepository.findAccountByVerificationCode(code);
    }

    @Override
    public void deleteVerifyCode(String username) {
        accountRepository.deleteVerifyCode(username);
    }

    @Transactional
    @Override
    public void saveSocialAccount(Account account) {
        accountRepository.saveSocialAccount(
                account.getUsername(), account.getPassword(),
                account.getIsEnable(), LocalDate.now(),account.getProvider());
        accountRoleRepository.setDefaultRole(account.getUsername());
    }

    @Override
    public void addVerifyCodeToVerifyAccount(String username, String email) throws UnsupportedEncodingException, MessagingException {
        String code = RandomString.make(64);
        accountRepository.addVerifyCodeToVerifyAccount(code,username);
        sendMailToVerifyAccount(username,email,code);
    }

    @Override
    public void activeAccount(String username) {
        accountRepository.activeAccount(username);
        deleteVerifyCode(username);
    }

    @Override
    public void sendMailToVerifyAccount(String username, String email, String randomCode) throws MessagingException, UnsupportedEncodingException {
        String subject = "Hãy xác thực email của bạn";
        String mailContent = "";
        String confirmUrl = "http://localhost:4200/verification?code=" + randomCode;

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setTo(email);
        helper.setFrom("lenga373737@gmail.com", "A03Cinema");
        helper.setSubject(subject);
        mailContent = "<p sytle='color:red;'>Xin chào " + username + " ,<p>" + "<p> Nhấn vào link sau để xác thực email của bạn:</p>" +
                "<h3><a href='" + confirmUrl + "'>Link Xác thực( nhấn vào đây)!</a></h3>" +
                "<p>A03 cinema</p>";
        helper.setText(mailContent, true);
        javaMailSender.send(message);
    }

}
