package com.codegym.cinema.service;

import com.codegym.cinema.entity.User;
import com.codegym.cinema.dto.user.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService{
    Page<User> findByNameUserAndIdCardAndPhoneAndAddress(String name, String idCard, String phone, Pageable pageable);

    void updateUser(int id, UserDTO userDTO);

    User findByUsername(String username);

    void updateUser(User user);

    User findUserByAccount_Username(String username);

    User findUserByEmail(String email);

    void saveSocialUser(User user);
}
