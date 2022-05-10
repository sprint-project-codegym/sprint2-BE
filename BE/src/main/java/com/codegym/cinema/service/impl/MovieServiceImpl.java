package com.codegym.cinema.service.impl;

import com.codegym.cinema.dto.CategoryDTO;
import com.codegym.cinema.dto.MovieCreateDTO;
import com.codegym.cinema.dto.RoomDTO;
import com.codegym.cinema.entity.Category;
import com.codegym.cinema.entity.Movie;
import com.codegym.cinema.entity.MovieCategory;
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
    public void addMovie(MovieCreateDTO movie) throws Exception {
        Integer deleteFlag = 1;
        movieRepository.createMovie(movie.getActor(), movie.getBanner(), movie.getDescription(), movie.getDirector(), movie.getStartDate(), movie.getEndDate(), movie.getMovieLength(), movie.getMovieName(), movie.getMovieStudio(), movie.getPoster(), movie.getTrailer(), deleteFlag);
        List<Integer> movieIds = movieRepository.search(movie.getActor(), movie.getBanner(), movie.getDescription(), movie.getDirector(), movie.getStartDate(), movie.getEndDate(), movie.getMovieLength(), movie.getMovieName(), movie.getMovieStudio(), movie.getPoster(), movie.getTrailer(), deleteFlag);
        System.out.println(movieIds);
        if (movieIds.size() == 1) {
            System.out.println(movie.getMovieCategoryList());
            for (CategoryDTO movieCategory : movie.getMovieCategoryList()) {
                System.out.println("" + movieIds.get(0) + movieCategory.getCategoryId());
                movieCategoryService.createMovieCategory(movieIds.get(0), movieCategory.getCategoryId());
            }
            for (RoomDTO movieRoom : movie.getMovieRoomList()) {
                movieRoomService.createMovieRoom(movieIds.get(0), movieRoom.getRoomId());
            }
        }
    }

    @Override
    public void updateMovie(int id, MovieCreateDTO movieCreateDTO) {
        movieRepository.saveMovie(id, movieCreateDTO.getActor(), movieCreateDTO.getBanner(), movieCreateDTO.getDescription(), movieCreateDTO.getDirector(), movieCreateDTO.getStartDate(), movieCreateDTO.getEndDate(), movieCreateDTO.getMovieLength(), movieCreateDTO.getMovieName(), movieCreateDTO.getMovieStudio(), movieCreateDTO.getPoster(), movieCreateDTO.getTrailer());
    }
}

