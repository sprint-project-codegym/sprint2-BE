package com.codegym.cinema.service;

import com.codegym.cinema.dto.MovieCreateDTO;
import com.codegym.cinema.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {

    void addMovie(MovieCreateDTO movie) throws Exception;

    void updateMovie(int id, MovieCreateDTO movieCreateDTO);
}
