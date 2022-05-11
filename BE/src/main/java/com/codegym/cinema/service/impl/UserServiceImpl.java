package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.User;
import com.codegym.cinema.repository.UserRepository;
import com.codegym.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //    @Override
    public void addNewUser(User user) {
//        userRepository.addNewUser(user);
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user.getUserId(), user.getName(), user.getBirthday(), user.getGender(), user.getEmail(),
                user.getIdCard(), user.getPhone());
    }

    @Override
    public User findUserByAccount_Username(String username) {
        return userRepository.findUserByAccount_Username(username);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public void saveSocialUser(User user) {
        userRepository.saveSocialUser(
                user.getName(), user.getAvatarUrl(),
                user.getEmail(), user.getEmail());
    }

}
