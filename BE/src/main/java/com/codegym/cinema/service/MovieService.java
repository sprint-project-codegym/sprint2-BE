package com.codegym.cinema.service;

import com.codegym.cinema.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    /**
     * Author: NhungHTC
     */
    List<Movie> getAllMovie();
    List<Movie> findAll();

}
