package com.codegym.cinema.service.impl;

import com.codegym.cinema.dto.CategoryDTO;
import com.codegym.cinema.dto.MovieCreateDTO;
import com.codegym.cinema.dto.RoomDTO;
import com.codegym.cinema.entity.Movie;
import com.codegym.cinema.entity.dto.MovieDTO;
import com.codegym.cinema.repository.MovieCategoryRepository;
import com.codegym.cinema.repository.MovieRepository;
import com.codegym.cinema.repository.MovieRoomRepository;
import com.codegym.cinema.service.MovieCategoryService;
import com.codegym.cinema.service.MovieRoomService;
import com.codegym.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


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
        movieRepository.createMovie(movie.getActor(), movie.getDescription(), movie.getDirector(), movie.getStartDate(), movie.getEndDate(), Integer.parseInt(movie.getMovieLength()), movie.getMovieName(), movie.getMovieStudio(), movie.getPoster(), movie.getTrailer(), deleteFlag);
        List<Integer> movieIds = movieRepository.search(movie.getActor(), movie.getDescription(), movie.getDirector(), movie.getStartDate(), movie.getEndDate(), Integer.parseInt(movie.getMovieLength()), movie.getMovieName(), movie.getMovieStudio(), movie.getPoster(), movie.getTrailer(), deleteFlag);
        System.out.println(movieIds);
        if (movieIds.size() == 1) {
            System.out.println(movie.getMovieCategoryList());
            for (CategoryDTO movieCategory : movie.getMovieCategoryList()) {
                System.out.println("" + movieIds.get(0) + movieCategory.getCategoryId());
                movieCategoryService.createMovieCategory(movieIds.get(0), movieCategory.getCategoryId());
            }
//            for (RoomDTO movieRoom : movie.getMovieRoomList()) {
//                movieRoomService.createMovieRoom(movieIds.get(0), movieRoom.getRoomId());
//            }
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

    /**
     * Author: KhoaTM
     */
    public static final int DEFAULT_PAGE = 0;
    public static final int DEFAULT_PAGE_SIZE = 8;


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


    /**
     * Author: NhungHTC
     */
    @Override
    public List<Movie> getAllMovie() {
        return movieRepository.getAllMovie();
    }

    /**
     * Author: NhungHTC
     */
    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    /**
     * Author: KhoaTM
     */
    @Override
    public Pageable getPageable(Optional<String> pageParam, Optional<String> pageSizeParam) {
        int page = DEFAULT_PAGE;
        int pageSize = DEFAULT_PAGE_SIZE;

        if (pageParam.isPresent() && !pageParam.get().trim().equals("")) {
            page = Integer.parseInt(pageParam.get().trim());
        }
        if (pageSizeParam.isPresent() && !pageSizeParam.get().trim().equals("")) {
            pageSize = Integer.parseInt(pageSizeParam.get().trim());
        }
        return PageRequest.of(page, pageSize);
    }

    /**
     * Author: KhoaTM
     */
    @Override
    public Page<Movie> findOnShowingMovies(Pageable pageable) {
        return movieRepository.findOnShowingMovies(pageable);
    }

    /**
     * Author: KhoaTM
     */
    @Override
    public Page<Movie> findUpComingMovies(Pageable pageable) {
        return movieRepository.findUpComingMovies(pageable);
    }

    /**
     * Author: KhoaTM
     */
    @Override
    public List<Movie> findTop3BySales() {
        return movieRepository.findTop3BySales();
    }

    /**
     * Author: KhoaTM
     */
    @Override
    public List<Movie> findPromotingMovies() {
        return movieRepository.findPromotingMovies();
    }

    /**
     * Author: KhoaTM
     */
    @Override
    public Page<Movie> findByTitleContaining(String keySearch, Pageable pageable) {
        return movieRepository.findByTitleContaining(keySearch, pageable);
    }

    /**
     * Author: KhoaTM
     */
    @Override
    public Page<Movie> advancedSearch(String keySearch, String categoryId, String date, String showTimeId, Pageable pageable) {
        return movieRepository.findByTitleAndCategoryAndDateAndShowTime(keySearch, categoryId, date, showTimeId, pageable);
    }

    /**
     * Author: DongVTH
     */
    @Override
    public Movie getDetailMovie(Integer id) {
        return movieRepository.findMovieByMovieId(id);

    }
}

