package com.codegym.cinema.repository;

import com.codegym.cinema.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticalRepository extends JpaRepository<Ticket, Integer> {
}
