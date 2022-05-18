package com.codegym.cinema.repository;
import com.codegym.cinema.entity.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketStatusRepository extends JpaRepository<TicketStatus,Integer> {
}
