package com.codegym.cinema.service;

import com.codegym.cinema.entity.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface AccountService {
    void updatePassword(String password, String username);

    Account findAccountByUsername(String username);

    Account findByUsernameToResetPassword(String username);

    void addVerifyCode(String username) throws MessagingException;

    void sendMailToResetPassword(String email, String code) throws MessagingException;

    Account findAccountByVerificationCode(String code);

    void deleteVerifyCode(String username);

    void saveSocialAccount(Account account);

    /*NgaLT*/
    void  addVerifyCodeToVerifyAccount(String username, String email) throws UnsupportedEncodingException, MessagingException;
    void activeAccount(String username);
    void sendMailToVerifyAccount(String username, String email, String randomCode) throws MessagingException, UnsupportedEncodingException;


}
