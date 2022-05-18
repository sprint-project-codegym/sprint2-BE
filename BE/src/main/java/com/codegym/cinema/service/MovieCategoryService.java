package com.codegym.cinema.service;

import com.codegym.cinema.entity.MovieCategory;

import java.util.List;

public interface MovieCategoryService {
    void createMovieCategory(Integer movieId, Integer categoryId);

    List<MovieCategory> findAll();
}
