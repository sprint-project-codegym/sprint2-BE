package com.codegym.cinema.service;

import com.codegym.cinema.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService {
    Page<Movie> findAll(Pageable page);
    void deleteMovie(String id);
    Movie findById(String id);
    Page<Movie> findByNameAndStudio(Pageable page, String name, String studio);
}
