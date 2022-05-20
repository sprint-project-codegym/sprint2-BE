package com.codegym.cinema.controller;

import com.codegym.cinema.dto.AccountDTO;
import com.codegym.cinema.entity.Account;
import com.codegym.cinema.entity.TransactionHistory;
import com.codegym.cinema.entity.User;
import com.codegym.cinema.service.AccountService;
import com.codegym.cinema.service.TransactionHistoryService;
import com.codegym.cinema.dto.user.UserDTO;
import com.codegym.cinema.entity.District;
import com.codegym.cinema.entity.Province;
import com.codegym.cinema.entity.Ward;
import com.codegym.cinema.service.DistrictService;
import com.codegym.cinema.service.ProvinceService;
import com.codegym.cinema.service.UserService;
import com.codegym.cinema.service.WardService;
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

import org.springframework.validation.annotation.Validated;


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

    @Autowired
    DistrictService districtService;

    @Autowired
    ProvinceService provinceService;
    @Autowired
    WardService wardService;

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

    @GetMapping("/member/user/list")
    public ResponseEntity<Page<User>> getUser(@RequestParam(value = "name", defaultValue = "") String name,
                                              @RequestParam(value = "idCard", defaultValue = "") String idCard,
                                              @RequestParam(value = "phone", defaultValue = "") String phone,
                                              @RequestParam(value = "page", defaultValue = "0") Integer page,
                                              @RequestParam(value = "size", defaultValue = "5") Integer size) {
        Page<User> users = null;
        try {
            Pageable pageable = PageRequest.of(page, 2);
            users = userService.findByNameUserAndIdCardAndPhoneAndAddress(name, idCard, phone, pageable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (users == null || users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/member/user/list/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        User user = null;
        try {
            user = userService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/member/user/edit/{id}")
    public ResponseEntity<List<FieldError>> editUser(@PathVariable("id") int id,
                                                     @Validated @RequestBody UserDTO userDTO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
            }
            userService.updateUser(id, userDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/member/user/province")
    public ResponseEntity<List<Province>> getListProvince() {
        List<Province> provinces = null;
        try {
            provinces = provinceService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(provinces, HttpStatus.OK);
    }

    @GetMapping("/member/user/district")
    public ResponseEntity<List<District>> getListDistrict(@RequestParam(value = "provinceId", defaultValue = "") String provinceId) {
        List<District> districts = null;
        try {
            districts = districtService.findByProvinceId(Integer.parseInt(provinceId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(districts, HttpStatus.OK);
    }

    @GetMapping("/member/user/ward")
    public ResponseEntity<List<Ward>> getListWard(@RequestParam(value = "districtId", defaultValue = "") String districtId) {
        List<Ward> wards = null;
        try {
            wards = wardService.findByDistrictId(Integer.parseInt(districtId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(wards, HttpStatus.OK);
    }
}

