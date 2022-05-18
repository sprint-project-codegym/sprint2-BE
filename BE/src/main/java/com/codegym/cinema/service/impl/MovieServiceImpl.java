package com.codegym.cinema.service.impl;

import com.codegym.cinema.dto.CategoryDTO;
import com.codegym.cinema.dto.MovieCreateDTO;
import com.codegym.cinema.dto.RoomDTO;
import com.codegym.cinema.entity.Category;
import com.codegym.cinema.entity.Movie;
import com.codegym.cinema.entity.MovieCategory;
import com.codegym.cinema.entity.dto.MovieDTO;
import com.codegym.cinema.repository.MovieCategoryRepository;
import com.codegym.cinema.repository.MovieRepository;
import com.codegym.cinema.repository.MovieRoomRepository;
import com.codegym.cinema.service.MovieCategoryService;
import com.codegym.cinema.service.MovieRoomService;
import com.codegym.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieCategoryService movieCategoryService;
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieCategoryRepository movieCategoryRepository;
    @Autowired
    MovieRoomRepository movieRoomRepository;
    @Autowired
    MovieRoomService movieRoomService;

    @Override
    public void addMovie(List<MovieDTO> listMovieDTO) {
        for (MovieDTO movieDTO : listMovieDTO) {
            movieRepository.save(movieDTO.getMovie());
        }

    }

    @Override
    public void editMovie(List<MovieDTO> listMovieDTO) {
        Integer idMovie = listMovieDTO.get(0).getMovie().getMovieId();
        Movie movie = listMovieDTO.get(0).getMovie();
        movieRepository.editMovie(movie.getMovieName(), movie.getPosterMovie(), movie.getStartDate(), movie.getEndDate(),
                movie.getMovieStudio(), movie.getActor(), movie.getDirector(), movie.getMovieLength(), movie.getTrailer(),
                movie.getMovieId());
        movieCategoryRepository.deleteMovieCategory(idMovie);
        for (MovieDTO movieDTO : listMovieDTO) {
            movieCategoryRepository.createMovieCategory(idMovie, movieDTO.getCategoryId());
        }
    }
}

