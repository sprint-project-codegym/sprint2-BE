package com.codegym.cinema.repository;

import com.codegym.cinema.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;

public interface AccountRepository  extends JpaRepository<Account, String> {
    //NgaLT query thêm mới account
    @Modifying
    @Query(value = "INSERT INTO Account (`username`, `password`, `register_date`, `account_status`) " +
            "values (?1,?2,?3,?4)",nativeQuery = true)
    void createAccount(@Param("username") String username,
                       @Param("password") String password,
                       @Param("registerDate") LocalDate registerDate,
                       @Param("accountStatusId") String accountStatus);

    @Query(value = "update account set verification_code=? where username=? ", nativeQuery = true)
    @Modifying
    void addVerifyToVerifyAccount(String code, String username);
}
