package com.codegym.cinema.repository;

import com.codegym.cinema.entity.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Integer> {

    /**
     * LuanVT
     */
    @Query(value = "select * from `account` inner join `transaction_history` on" +
            "`account`.username = `transaction_history`.username " +
            "where `account`.username =?1", nativeQuery = true)
    List<TransactionHistory> findTransactionByUsername(String username);
}
