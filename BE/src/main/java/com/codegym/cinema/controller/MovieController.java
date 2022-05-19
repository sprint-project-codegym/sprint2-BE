package com.codegym.cinema.controller;

import com.codegym.cinema.dto.MovieCreateDTO;
import com.codegym.cinema.entity.Movie;
import com.codegym.cinema.entity.dto.MovieDTO;
import com.codegym.cinema.repository.MovieCategoryRepository;
import com.codegym.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieCategoryRepository movieCategoryRepository;

    //NghiaND get all list movie (manage)
    @GetMapping("/manage/list")
    public ResponseEntity<Page<Movie>> getMovie(@RequestParam(value = "name", defaultValue = "") String name,
                                                @RequestParam(value = "studio", defaultValue = "") String studio,
                                                @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Movie> movies = movieService.findByNameAndStudio(pageable, name, studio);
        if (movies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    //NghiaND get delete movie (manage)
    @DeleteMapping("/manage/delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") String id) {
        Movie movie = movieService.findById(id);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        movieService.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * Author: NhungHTC
     */
    @GetMapping("/all_movie")
    public ResponseEntity<List<Movie>> getAllMovie() {
        try {
            List<Movie> movie = movieService.getAllMovie();
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Author: KhoaTM
     */
    @GetMapping("/on-showing")
    public ResponseEntity<Page<Movie>> getOnShowingMovies(@RequestParam("page") Optional<String> pageParam,
                                                          @RequestParam("size") Optional<String> pageSizeParam) {
        try {
            Pageable pageable = movieService.getPageable(pageParam, pageSizeParam);
            Page<Movie> movieList = movieService.findOnShowingMovies(pageable);
            if (movieList == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movieList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Author: KhoaTM
     */
    @GetMapping("/up-coming")
    public ResponseEntity<Page<Movie>> getUpComingMovies(@RequestParam("page") Optional<String> pageParam,
                                                         @RequestParam("size") Optional<String> pageSizeParam) {
        try {
            Pageable pageable = movieService.getPageable(pageParam, pageSizeParam);
            Page<Movie> movieList = movieService.findUpComingMovies(pageable);
            if (movieList == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movieList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * Author: KhoaTM
     */
    @GetMapping("/top-3")
    public ResponseEntity<List<Movie>> getTop3BySales() {
        try {
            List<Movie> movieList = movieService.findTop3BySales();
            if (movieList == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movieList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Author: KhoaTM
     */
    @GetMapping("/promoting")
    public ResponseEntity<List<Movie>> getPromotingMovies() {
        try {
            List<Movie> movieList = movieService.findPromotingMovies();
            if (movieList == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movieList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Author: KhoaTM
     */
    @GetMapping("/search")
    public ResponseEntity<Page<Movie>> searchByKey(@RequestParam("q") Optional<String> keySearchParam,
                                                   @RequestParam("page") Optional<String> pageParam,
                                                   @RequestParam("size") Optional<String> pageSizeParam) {
        try {
            String keySearch = "";
            if (keySearchParam.isPresent()) {
                keySearch = keySearchParam.get().trim();
            }
            Pageable pageable = movieService.getPageable(pageParam, pageSizeParam);
            Page<Movie> movieList = movieService.findByTitleContaining(keySearch, pageable);
            if (movieList == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(movieList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Author: KhoaTM
     */
    @GetMapping("/advancedSearch")
    public ResponseEntity<Page<Movie>> advancedSearch
    (@RequestParam("q") Optional<String> keySearchParam,
     @RequestParam("categoryId") Optional<String> categoryIdParam,
     @RequestParam("date") Optional<String> dateParam,
     @RequestParam("showTimeId") Optional<String> showTimeIdParam,
     @RequestParam("page") Optional<String> pageParam,
     @RequestParam("size") Optional<String> pageSizeParam) {
        try {
            String keySearch = "";
            String categoryId = "";
            String date = "";
            String showTimeId = "";

            if (keySearchParam.isPresent()) {
                keySearch = keySearchParam.get().trim();
            }
            if (categoryIdParam.isPresent()) {
                categoryId = categoryIdParam.get().trim();
            }
            if (dateParam.isPresent()) {
                date = dateParam.get().trim();
            }
            if (showTimeIdParam.isPresent()) {
                showTimeId = showTimeIdParam.get().trim();
            }

            Pageable pageable = movieService.getPageable(pageParam, pageSizeParam);
            Page<Movie> movieList = movieService.advancedSearch(keySearch, categoryId, date, showTimeId, pageable);
            if (movieList == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(movieList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Author: AnhNDH
     */
//    @PostMapping("/add_movie")
//    public ResponseEntity<Void> addMovie(@RequestBody List<MovieDTO> listMovieDTO) {
//        try {
//            movieService.addMovie(listMovieDTO);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
    @PostMapping("/create")
    public ResponseEntity<Void> addMovie(@RequestBody MovieCreateDTO listMovieDTO) {
        try {
            movieService.addMovie(listMovieDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Author: AnhNDH
     */
    @PutMapping("/edit_movie")
    public ResponseEntity<Void> editMovie(@RequestBody List<MovieDTO> listMovieDTO) {
        try {
            movieService.editMovie(listMovieDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Author: DongVTH
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<Movie> getDetailMovie(@PathVariable("id") Integer id) {
        Movie movie = movieService.getDetailMovie(id);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
}