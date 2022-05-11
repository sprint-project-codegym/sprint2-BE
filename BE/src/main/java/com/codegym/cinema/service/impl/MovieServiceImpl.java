package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.Movie;
import com.codegym.cinema.repository.MovieRepository;
import com.codegym.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {


    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovie() {
        return movieRepository.getAllMovie();
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}
