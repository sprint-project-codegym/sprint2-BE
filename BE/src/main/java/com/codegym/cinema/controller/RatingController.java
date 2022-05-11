package com.codegym.cinema.controller;

import com.codegym.cinema.entity.Rating;
import com.codegym.cinema.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/rating")
public class RatingController {
    @Autowired
    RatingService ratingService;

    /**
     * Author: DongVTH
     */
    @PostMapping(value = "/create", produces = {"application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rating> createContract(@Validated @RequestBody Rating rating, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        ratingService.saveRating(rating);
        return new ResponseEntity<>(rating, HttpStatus.CREATED);
    }
}
