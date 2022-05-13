package com.codegym.cinema.repository;


import com.codegym.cinema.entity.MovieStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieStatusRepository extends JpaRepository<MovieStatus,Integer> {


}
