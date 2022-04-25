package com.codegym.cinema.service;

import com.codegym.cinema.entity.TransactionHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TransactionHistoryService {
    Page<TransactionHistory> findTransactionByUsername(String username, Pageable pageable);
}
