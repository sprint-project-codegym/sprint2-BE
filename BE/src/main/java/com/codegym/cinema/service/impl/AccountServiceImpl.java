package com.codegym.cinema.service.impl;

import com.codegym.cinema.dto.AccountDTO;
import com.codegym.cinema.entity.Account;
import com.codegym.cinema.repository.AccountRepository;
import com.codegym.cinema.repository.AccountRoleRepository;
import com.codegym.cinema.service.AccountService;
import com.codegym.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountRoleRepository accountRoleRepository;

    @Autowired
    UserService userService;

    @Autowired
    private JavaMailSender emailSender;


    @Override
    public void setNewPassword(AccountDTO accountDTO) {
        accountDTO.setNewPassword(accountDTO.getNewPassword());
        accountRepository.saveAccountDTO(accountDTO.getNewPassword(), accountDTO.getUsername());
    }

    @Override
    public void updatePassword(String password, String username) {
        accountRepository.updatePassword(password, username);
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
        sendMailToResetPassword(account.getUser().getEmail(), code);
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
        this.emailSender.send(message);
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
                account.getIsEnable(), LocalDate.now(), account.getProvider());
        accountRoleRepository.setDefaultRole(account.getUsername());
    }
}
