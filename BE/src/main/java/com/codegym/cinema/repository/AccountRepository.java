package com.codegym.cinema.repository;

import com.codegym.cinema.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface AccountRepository extends JpaRepository<Account, String> {

    /**
     * LuanVT
     */
    @Query(value = "select * from `account` where username = ?1", nativeQuery = true)
    Account findAccountByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "update `account` set `password`=?1 where `username`=?2", nativeQuery = true)
    void saveAccountDTO(String newPassword, String username);
}
