package com.codegym.cinema.repository;

import com.codegym.cinema.entity.MovieCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCategoryRepository extends JpaRepository<MovieCategory,Integer> {
}
