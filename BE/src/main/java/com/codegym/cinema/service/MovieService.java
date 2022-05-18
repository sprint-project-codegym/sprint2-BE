package com.codegym.cinema.service;

import com.codegym.cinema.dto.MovieCreateDTO;
import com.codegym.cinema.entity.Movie;
import com.codegym.cinema.entity.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {

    void addMovie(List<MovieDTO> movie);

    void editMovie(List<MovieDTO> listMovieDTO);
}
