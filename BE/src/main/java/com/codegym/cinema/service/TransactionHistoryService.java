package com.codegym.cinema.service;

import com.codegym.cinema.entity.TransactionHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TransactionHistoryService {
    Page<TransactionHistory> findAllTransaction(String username, Pageable pageable);

    Page<TransactionHistory> findTransactionByUsername(String username, Boolean status, String startDate, String endDate, Pageable pageable);

    Page<TransactionHistory> findTransactionStatus(String username, Boolean status, Pageable pageable);
}
