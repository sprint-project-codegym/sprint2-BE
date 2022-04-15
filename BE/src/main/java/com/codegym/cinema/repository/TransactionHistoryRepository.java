package com.codegym.cinema.repository;

import com.codegym.cinema.entity.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory,Integer> {
}
