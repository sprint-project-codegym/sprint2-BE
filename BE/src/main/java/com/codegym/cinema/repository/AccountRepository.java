package com.codegym.cinema.repository;

import com.codegym.cinema.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

public interface AccountRepository extends JpaRepository<Account, String> {

//    @Modifying
//    @Query(value = "select * from account where username = ?", nativeQuery = true)
    Account findByUsername(String username);

    @Query(value="select * from account where username = ? and provider is null", nativeQuery = true)
    Account findByUsernameToResetPassword(String username);

    @Transactional
    @Modifying
    @Query(value = "update account set password = ? where username = ?", nativeQuery = true)
    void updatePassword(String password, String username);

    @Transactional
    @Modifying
    @Query(value = "update account set verification_code = ? where username = ?", nativeQuery = true)
    void addVerifyCode(String code, String username);

    @Transactional
    @Query(value = "select * from account where verification_code=?", nativeQuery = true)
    Account findAccountByVerificationCode(String code);

    @Transactional
    @Modifying
    @Query(value = "update account set verification_code = null where username = ?", nativeQuery = true)
    void deleteVerifyCode(String username);

    @Transactional
    @Modifying
    @Query(value="insert into account(username,password,is_enable,register_date,provider) value (?,?,?,?,?)", nativeQuery=true)
    void saveSocialAccount(String username, String password, Boolean enable, LocalDate register_date,String provider);
}
