package com.codegym.cinema.service;

import com.codegym.cinema.entity.TransactionHistory;

import java.util.List;

public interface TransactionHistoryService {
    List<TransactionHistory> findTransactionByUsername(String username);
}
