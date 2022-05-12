package com.codegym.cinema.controller;

import com.codegym.cinema.dto.AccountDTO;
import com.codegym.cinema.entity.Account;
import com.codegym.cinema.entity.TransactionHistory;
import com.codegym.cinema.entity.User;
import com.codegym.cinema.service.AccountService;
import com.codegym.cinema.service.TransactionHistoryService;
import com.codegym.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PutMapping(value = "/member/editUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FieldError>> editUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        try {
            userService.updateUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
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
        if (BCrypt.checkpw(accountDTO.getOldPassword(), account.getPassword())) {
            accountService.setNewPassword(accountDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/member/transaction")
    public ResponseEntity<Page<TransactionHistory>> getTransactionByUsername(@RequestParam(defaultValue = "0") int page,
                                                                             @RequestParam(defaultValue = "3") int size,
                                                                             @RequestParam(defaultValue = "") String username,
                                                                             @RequestParam(defaultValue = "") Boolean status,
                                                                             @RequestParam(defaultValue = "") String startDate,
                                                                             @RequestParam(defaultValue = "") String endDate) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TransactionHistory> transactions;
        transactions = transactionHistoryService.findTransactionByUsername(username, status, startDate, endDate, pageable);
        if (transactions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping("/member/transaction-status")
    public ResponseEntity<Page<TransactionHistory>> getTransactionByStatus(@RequestParam(defaultValue = "0") int page,
                                                                             @RequestParam(defaultValue = "3") int size,
                                                                             @RequestParam(defaultValue = "") String username,
                                                                             @RequestParam(defaultValue = "") Boolean status) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TransactionHistory> transactions;
        transactions = transactionHistoryService.findTransactionStatus(username, status, pageable);
        if (transactions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping("/member/transaction-list")
    public ResponseEntity<Page<TransactionHistory>> getAllTransaction(@RequestParam(defaultValue = "0") int page,
                                                                      @RequestParam(defaultValue = "3") int size,
                                                                      @RequestParam(defaultValue = "") String username) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TransactionHistory> transactions;
        transactions = transactionHistoryService.findAllTransaction(username, pageable);
        if (transactions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}

