package com.codegym.cinema.repository;

import com.codegym.cinema.entity.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowTimeRepository extends JpaRepository<ShowTime,Integer> {
}
