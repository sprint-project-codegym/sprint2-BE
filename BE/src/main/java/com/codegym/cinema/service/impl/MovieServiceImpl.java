package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.Movie;
import com.codegym.cinema.repository.MovieCategoryRepository;
import com.codegym.cinema.repository.MovieRepository;
import com.codegym.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    /**
     * Author: KhoaTM
     */
    public static final int DEFAULT_PAGE = 0;
    public static final int DEFAULT_PAGE_SIZE = 8;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieCategoryRepository movieCategoryRepository;

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
