package com.codegym.cinema.service;

import com.codegym.cinema.entity.User;

public interface UserService {
    User findByUsername(String username);

    void updateUser(User user);

    User findUserByAccount_Username(String username);

    User findUserByEmail(String email);

    void saveSocialUser(User user);
}
