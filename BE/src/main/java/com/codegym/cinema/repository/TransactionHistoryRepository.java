package com.codegym.cinema.repository;

import com.codegym.cinema.entity.TransactionHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Integer> {

    /**
     * LuanVT
     */
    @Query(value = "select * from `transaction_history` " +
            "where `transaction_history`.username =?1", nativeQuery = true)
    Page<TransactionHistory> findAllTransaction(String username, Pageable pageable);

    @Query(value = "select * from `transaction_history`" +
            " where transaction_history.username =?1 and transaction_history.status =?2" +
            " and transaction_date between ?3 and ?4", nativeQuery = true)
    Page<TransactionHistory> findTransactionByUsername(String username, Boolean status, String startDate, String endDate, Pageable pageable);

}
