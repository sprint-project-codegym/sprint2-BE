package com.codegym.cinema.controller;

import com.codegym.cinema.dto.AccountDTO;
import com.codegym.cinema.entity.Account;
import com.codegym.cinema.entity.TransactionHistory;
import com.codegym.cinema.entity.User;
import com.codegym.cinema.service.AccountService;
import com.codegym.cinema.service.TransactionHistoryService;
import com.codegym.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionHistoryService transactionHistoryService;

    @GetMapping("/member/user/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable(name = "username") String username) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(value = "/member/editUser", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> editUser(@RequestBody User user) {
        try {
            userService.updateUser(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/member/account/{username}")
    public ResponseEntity<Account> getAccountByUsername(@PathVariable(name = "username") String username) {
        Account account = accountService.findAccountByUsername(username);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PutMapping("/member/setPass")
    public ResponseEntity<AccountDTO> setNewPassword(@RequestBody AccountDTO accountDTO) {
        Account account = accountService.findAccountByUsername(accountDTO.getUsername());
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (accountDTO.getOldPassword().equals(account.getPassword())) {
            accountService.setNewPassword(accountDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/member/transaction/{username}")
    public ResponseEntity<List<TransactionHistory>> getTransactionByUsername(@PathVariable(name = "username") String username) {
        List<TransactionHistory> transactions = transactionHistoryService.findTransactionByUsername(username);
        if (transactions == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}

