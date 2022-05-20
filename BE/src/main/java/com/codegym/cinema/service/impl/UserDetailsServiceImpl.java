package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.Account;
import com.codegym.cinema.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = null;
        try {
            account = accountRepository.findByUsername(username);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
//        if (account == null) {
//            throw new UsernameNotFoundException("User " + username + " was not found in the database");
//        }
        return MyUserDetailsImpl.build(account);
    }
}
