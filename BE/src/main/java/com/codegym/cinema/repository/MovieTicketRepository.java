package com.codegym.cinema.repository;

import com.codegym.cinema.entity.MovieTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTicketRepository extends JpaRepository<MovieTicket,Integer> {
}
