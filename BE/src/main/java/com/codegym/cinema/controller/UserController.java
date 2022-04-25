package com.codegym.cinema.controller;

import com.codegym.cinema.dto.UserDTO;
import com.codegym.cinema.entity.Ticket;
import com.codegym.cinema.service.AccountRoleService;
import com.codegym.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AccountRoleService accountRoleService;

    @PostMapping(value = "/signup")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.NOT_ACCEPTABLE);
        }
        try {
            Map<String, String> listError = new HashMap<>();
            if (userService.findUserByUsername(userDTO.getUsername()) != null) {
                listError.put("existAccount", "Tên tài khoản đã tồn tại. Vui lòng nhập tên tài khoản khác.");
            }
            if (userService.findUserByIdCard(userDTO.getIdCard()) != null) {
                listError.put("existIdCard", "Số CMND đã tồn tại. Vui lòng nhập số CMND khác.");
            }
            if (userService.findUserByEmail(userDTO.getEmail()) != null) {
                listError.put("existEmail", "Email đã tồn tại. Vui lòng nhập số email khác.");
            }
            if (!listError.isEmpty()) {
                return ResponseEntity.badRequest().body(listError);
            }
            userService.createUser(userDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
