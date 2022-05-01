package com.codegym.cinema.service;

import com.codegym.cinema.dto.SocialUserDto;
import com.codegym.cinema.entity.Account;
import com.codegym.cinema.entity.User;

public interface UserService {
//    void addNewUser(User user);
    User findUserByAccount_Username(String username);
    User findUserByEmail(String email);
    void saveSocialUser(User user);
}
