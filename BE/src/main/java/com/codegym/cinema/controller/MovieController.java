package com.codegym.cinema.controller;

import com.codegym.cinema.entity.Movie;
import com.codegym.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/all_movie")
    public ResponseEntity<List<Movie>> getAllMovie() {
        try {
            List<Movie> movie = movieService.getAllMovie();
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
