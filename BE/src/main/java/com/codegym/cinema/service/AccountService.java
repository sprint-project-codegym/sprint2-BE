package com.codegym.cinema.service;

import com.codegym.cinema.entity.Account;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface AccountService {
    void  addVerifyToVerifyAccount(String username, String email) throws UnsupportedEncodingException, MessagingException;
    void sendMailToVerifyAccount(String username, String email, String randomCode) throws MessagingException, UnsupportedEncodingException;
    Account findAccountByVerificationCodeToActiveAccount(String code);
    void activeAccount(String username);
    void deleteVerifyCode(String username);
}
