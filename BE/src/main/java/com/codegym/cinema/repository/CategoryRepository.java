package com.codegym.cinema.repository;

import com.codegym.cinema.entity.Category;
import com.codegym.cinema.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
