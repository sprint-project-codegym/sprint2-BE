package com.codegym.cinema.controller;

import com.codegym.cinema.dto.MovieCreateDTO;
import com.codegym.cinema.entity.*;
import com.codegym.cinema.entity.dto.MovieDTO;
import com.codegym.cinema.service.CategoryService;
import com.codegym.cinema.service.MovieCategoryService;
import com.codegym.cinema.service.MovieService;
import com.sun.org.apache.xpath.internal.objects.XNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    MovieCategoryService movieCategoryService;

    @GetMapping("/category")
    public List<Category> getCategory() {
        return categoryService.getCategory();
    }

    //    @PostMapping("/create")
//    public ResponseEntity<Void> addMovie(@RequestBody MovieCreateDTO listMovieDTO) {
//        try {
//        movieService.addMovie(listMovieDTO);
//        return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
    @PostMapping("/create")
    public ResponseEntity<Void> addMovie(@RequestBody List<MovieDTO> listMovieDTO) {
        try {
            movieService.addMovie(listMovieDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit_movie")
    public ResponseEntity<Void> editMovie(@RequestBody List<MovieDTO> listMovieDTO) {
        try {
            movieService.editMovie(listMovieDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
