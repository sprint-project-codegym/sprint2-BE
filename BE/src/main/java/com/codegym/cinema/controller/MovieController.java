package com.codegym.cinema.controller;

import com.codegym.cinema.entity.Movie;
import com.codegym.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    //NghiaND get all list movie (manage)
    @GetMapping("/manage/list")
    public ResponseEntity<Page<Movie>> getMovie (@RequestParam(value = "name", defaultValue = "") String name,
                                                 @RequestParam(value = "studio", defaultValue = "") String studio,
                                                 @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                 @RequestParam(value = "size", defaultValue = "10") Integer size)

    {
        Pageable pageable = PageRequest.of(page, size);
        Page<Movie> movies  = movieService.findByNameAndStudio(pageable,name,studio);
        if (movies.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    //NghiaND get delete movie (manage)
    @DeleteMapping("/manage/delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") String id){
        Movie movie = movieService.findById(id);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        movieService.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
