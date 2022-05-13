package com.codegym.cinema.service;

import com.codegym.cinema.dto.SocialUserDto;
import com.codegym.cinema.dto.UserDTO;
import com.codegym.cinema.entity.Account;
import com.codegym.cinema.entity.User;
import org.springframework.data.repository.query.Param;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface UserService {
    /*HauLC*/
    User findByUsername(String username);
    User findByEmail(String email);
    void saveSocialUser(User user);

    /*NgaLT*/
    void createUser(UserDTO userDTO) throws UnsupportedEncodingException, MessagingException;
    User findUserByIdCard(@Param("idCard") String idCard);
}
