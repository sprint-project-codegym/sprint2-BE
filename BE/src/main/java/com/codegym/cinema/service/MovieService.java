package com.codegym.cinema.service;

import com.codegym.cinema.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MovieService {

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


}
