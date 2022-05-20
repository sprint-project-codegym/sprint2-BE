package com.codegym.cinema.service;


import com.codegym.cinema.dto.MovieCreateDTO;
import com.codegym.cinema.entity.Movie;
import com.codegym.cinema.entity.dto.MovieDTO;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;


@Service
public interface MovieService {
    void addMovie(MovieCreateDTO movie) throws Exception;

    void editMovie(List<MovieDTO> listMovieDTO);

    Page<Movie> findAll(Pageable page);

    void deleteMovie(String id);

    Movie findById(String id);

    Page<Movie> findByNameAndStudio(Pageable page, String name, String studio);

    /**
     * Author: NhungHTC
     */
    List<Movie> getAllMovie();

    /**
     * Author: NhungHTC
     */
    List<Movie> findAll();

    /**
     * Author: KhoaTM
     */
    Pageable getPageable(Optional<String> pageParam, Optional<String> pageSizeParam);

    /**
     * Author: KhoaTM
     */
    Page<Movie> findOnShowingMovies(Pageable pageable);

    /**
     * Author: KhoaTM
     */
    Page<Movie> findUpComingMovies(Pageable pageable);

    /**
     * Author: KhoaTM
     */
    List<Movie> findTop3BySales();

    /**
     * Author: KhoaTM
     */
    List<Movie> findPromotingMovies();

    /**
     * Author: KhoaTM
     */
    Page<Movie> findByTitleContaining(String keySearch, Pageable pageable);

    /**
     * Author: KhoaTM
     */
    Page<Movie> advancedSearch(String keySearch, String categoryId, String date, String showTimeId, Pageable pageable);


    /**
     * Author: DongVTH
     */
    Movie getDetailMovie(Integer movieId);
}
