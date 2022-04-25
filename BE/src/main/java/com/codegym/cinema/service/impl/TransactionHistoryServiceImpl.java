package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.TransactionHistory;
import com.codegym.cinema.repository.TransactionHistoryRepository;
import com.codegym.cinema.service.TransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {

    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

    @Override
    public Page<TransactionHistory> findTransactionByUsername(String username, Pageable pageable) {
        return transactionHistoryRepository.findTransactionByUsername(username, pageable);
    }
}
