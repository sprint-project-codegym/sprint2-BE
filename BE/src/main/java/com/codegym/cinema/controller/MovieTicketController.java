package com.codegym.cinema.controller;

import com.codegym.cinema.entity.MovieTicket;
import com.codegym.cinema.service.MovieTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/movie_ticket")
public class MovieTicketController {

    @Autowired
    MovieTicketService movieTicketService;

    @GetMapping("/detail/{id}")
    public ResponseEntity<MovieTicket> getDetailMovie(@PathVariable("id") Integer id) {
        MovieTicket movieTicket = movieTicketService.getDetailMovieTicket(id);
        if (movieTicket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movieTicket, HttpStatus.OK);
    }
}
