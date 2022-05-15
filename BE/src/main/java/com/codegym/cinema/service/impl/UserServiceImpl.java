package com.codegym.cinema.service.impl;

import com.codegym.cinema.dto.SocialUserDto;
import com.codegym.cinema.dto.UserDTO;
import com.codegym.cinema.entity.Account;
import com.codegym.cinema.entity.User;
import com.codegym.cinema.repository.AccountRepository;
import com.codegym.cinema.repository.AccountRoleRepository;
import com.codegym.cinema.repository.UserRepository;
import com.codegym.cinema.service.AccountService;
import com.codegym.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

   @Autowired
   AccountRepository accountRepository;

    @Autowired
    AccountRoleRepository accountRoleRepository;

    @Autowired
    AccountService accountService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        return userRepository.findUserByAccount_Username(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public void saveSocialUser(User user) {
        userRepository.saveSocialUser(
                user.getName(),user.getAvatarUrl(),
                user.getEmail(),user.getEmail());
    }

    @Override
    public void createUser(UserDTO userDTO) throws UnsupportedEncodingException, MessagingException {
        Account account = new Account();
        account.setUsername(userDTO.getUsername());
        account.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        account.setRegisterDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        this.accountRepository.createAccount(account.getUsername(),account.getPassword(), LocalDate.now());

        User user = new User();

        user.setAvatarUrl(userDTO.getAvatarUrl());
        user.setBirthday(userDTO.getBirthday());
        user.setEmail(userDTO.getEmail());
        user.setGender(userDTO.getGender());
        user.setIdCard(userDTO.getIdCard());
        user.setName(userDTO.getName());
        user.setPhone(userDTO.getPhone());
        user.setAccount(account);
        user.setWard(userDTO.getWard());
        this.userRepository.createUser(user.getAvatarUrl(), user.getBirthday(),user.getEmail(),user.getGender(),
                user.getIdCard(),user.getName(), user.getPhone(),user.getAccount().getUsername(),user.getWard().getWardId());

        this.accountRoleRepository.setDefaultRole(account.getUsername());

        this.accountService.addVerifyCodeToVerifyAccount(account.getUsername(), user.getEmail());
    }

    @Override
    public User findUserByIdCard(String idCard) {
        return userRepository.findUserByIdCard(idCard);
    }

}
