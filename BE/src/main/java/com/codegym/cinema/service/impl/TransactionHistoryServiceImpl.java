package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.TransactionHistory;
import com.codegym.cinema.repository.TransactionHistoryRepository;
import com.codegym.cinema.service.TransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {

    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

    @Override
    public List<TransactionHistory> findTransactionByUsername(String username) {
        return transactionHistoryRepository.findTransactionByUsername(username);
    }
}
