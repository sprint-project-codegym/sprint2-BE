package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.Account;
import com.codegym.cinema.repository.AccountRepository;
import com.codegym.cinema.repository.AccountRoleRepository;
import com.codegym.cinema.service.AccountService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;


@Service
public class AccountServiceImpl implements AccountService {

//    @Autowired
//    private AccountRepository accountRepository;
//
//    @Autowired
//    JavaMailSender javaMailSender;
//
//    @Override
//    public void  addVerifyToVerifyAccount(String username, String email) throws UnsupportedEncodingException, MessagingException {
//        String code = RandomString.make(64);
//        accountRepository.addVerifyToVerifyAccount(code,username);
//        sendMailToVerifyAccount(username,email,code);
//    }
//
//    @Override
//    public void sendMailToVerifyAccount(String username, String email, String randomCode) throws MessagingException, UnsupportedEncodingException {
//        String subject = "Hãy xác thực email của bạn";
//        String mailContent = "";
//        String confirmUrl = "http://localhost:4200/verification?code=" + randomCode;
//
//        MimeMessage message = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
//        helper.setTo(email);
//        helper.setFrom("lenga373737@gmail.com", "A03Cinema");
//        helper.setSubject(subject);
//        mailContent = "<p sytle='color:red;'>Xin chào " + username + " ,<p>" + "<p> Nhấn vào link sau để xác thực email của bạn:</p>" +
//                "<h3><a href='" + confirmUrl + "'>Link Xác thực( nhấn vào đây)!</a></h3>" +
//                "<p>TÒA NHÀ CHO THUÊ</p>";
//        helper.setText(mailContent, true);
//        javaMailSender.send(message);
//    }
}
