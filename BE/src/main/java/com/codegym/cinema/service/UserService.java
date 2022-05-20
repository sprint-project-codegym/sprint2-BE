package com.codegym.cinema.service;

import com.codegym.cinema.dto.UserDTO;
import com.codegym.cinema.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    Page<User> findByNameUserAndIdCardAndPhoneAndAddress(String name, String idCard, String phone, Pageable pageable);

    void updateUser(int id, UserDTO userDTO);

    void updateUser(User user);

    User findUserByAccount_Username(String username);


    User findById(int id);
}
