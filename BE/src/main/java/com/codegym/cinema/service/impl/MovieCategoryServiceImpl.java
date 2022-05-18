package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.MovieCategory;
import com.codegym.cinema.repository.MovieCategoryRepository;
import com.codegym.cinema.service.MovieCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieCategoryServiceImpl implements MovieCategoryService {
    @Autowired
    MovieCategoryRepository movieCategoryRepository;

    @Override
    public List<MovieCategory> findAll() {
        return movieCategoryRepository.findAll();
    }

    @Override
    public void createMovieCategory(Integer movieId, Integer category) {
        movieCategoryRepository.createMovieCategory(movieId, category);
    }
}
