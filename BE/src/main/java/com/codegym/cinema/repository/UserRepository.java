package com.codegym.cinema.repository;

import com.codegym.cinema.entity.Account;
import com.codegym.cinema.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

public interface UserRepository extends JpaRepository<User, Integer> {
//    void addNewUser(User user);
    User findUserByAccount_Username(String username);
    User findUserByEmail(String email);

    @Transactional
    @Modifying
    @Query(value="insert into user(name,avatar_url,email,username) value (?,?,?,?)", nativeQuery=true)
    void saveSocialUser(String name, String avatar_url, String email, String username);

}
