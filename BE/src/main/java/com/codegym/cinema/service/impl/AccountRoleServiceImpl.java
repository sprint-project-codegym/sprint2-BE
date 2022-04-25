package com.codegym.cinema.service.impl;


import com.codegym.cinema.repository.AccountRoleRepository;
import com.codegym.cinema.service.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountRoleServiceImpl implements AccountRoleService {
    @Autowired
    private AccountRoleRepository accountRoleRepository;

    @Override
    public void saveAccountRoleUser(String username, int i) {
        this.accountRoleRepository.saveAccountRole(username, i);
    }
}
