package com.codegym.cinema.service;

import com.codegym.cinema.dto.AccountDTO;
import com.codegym.cinema.entity.Account;

public interface AccountService {
    Account findAccountByUsername(String username);

    void setNewPassword(AccountDTO accountDTO);
}
