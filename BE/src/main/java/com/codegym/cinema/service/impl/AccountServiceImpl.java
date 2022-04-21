package com.codegym.cinema.service.impl;

import com.codegym.cinema.dto.AccountDTO;
import com.codegym.cinema.entity.Account;
import com.codegym.cinema.repository.AccountRepository;
import com.codegym.cinema.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account findAccountByUsername(String username) {
        return this.accountRepository.findAccountByUsername(username);
    }

    @Override
    public void setNewPassword(AccountDTO accountDTO) {
        accountDTO.setNewPassword(accountDTO.getNewPassword());
        accountRepository.saveAccountDTO(accountDTO.getNewPassword(),accountDTO.getUsername());
    }
}
