package com.codegym.cinema.service;

import com.codegym.cinema.dto.UserDTO;
import com.codegym.cinema.entity.Ticket;
import com.codegym.cinema.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserService {
    void createUser(UserDTO userDTO);

    User findUserByUsername(@Param("username") String username);

    User findUserByIdCard(@Param("idCard") String idCard);

    User findUserByEmail(@Param("email") String email);

//    Boolean existsUsersByUsername(String username);
//
//    Boolean existsUsersByIdCard(String idCard);
//
//    Boolean existsUsersByEmail(String email);
}
