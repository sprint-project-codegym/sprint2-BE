package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.Movie;
import com.codegym.cinema.repository.MovieRepository;
import com.codegym.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;


    @Override
    public Page<Movie> findAll(Pageable page) {
        return movieRepository.findAll(page);
    }

    @Override
    public void deleteMovie(String id) {
        movieRepository.deleteByMovieId(id);
    }

    @Override
    public Movie findById(String id) {
        return movieRepository.findById(id);
    }

    @Override
    public Page<Movie> findByNameAndStudio(Pageable page, String name, String studio) {
        return movieRepository.findByNameAndStudio(name, studio, page);
    }
}
