package com.codegym.cinema.controller;


import com.codegym.cinema.entity.MovieTicket;
import com.codegym.cinema.service.MovieTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/movie_ticket")
public class MovieTicketController {

    @Autowired
    MovieTicketService movieTicketService;

    @GetMapping("/information/{id}")
    public ResponseEntity<MovieTicket> getDetailMovie(@PathVariable("id") Integer id) {
        MovieTicket movieTicket = movieTicketService.getDetailMovieTicket(id);
        if (movieTicket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movieTicket, HttpStatus.OK);
    }


    //Method: get all movie ticket by movie id - NhungHTC

    @GetMapping("api/employee/saleTicket/listMovieTicket/showDate/{showDate}")
    public ResponseEntity<List<MovieTicket>> showAllMovieTicket(@PathVariable String showDate) {

        try {
            List<MovieTicket> ticketList = movieTicketService.showAllMovieTicketByShowDate(showDate);
            if (ticketList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(ticketList, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

//Method: et all movie ticket by movie id and show date - NhungHTC

    @GetMapping("api/employee/saleTicket/listMovieTicket/{movieId}/{showDate}")
    public ResponseEntity<List<MovieTicket>> showAllMovieTicket(@PathVariable Integer movieId, @PathVariable String showDate) {

        try {
            List<MovieTicket> ticketList = movieTicketService.showAllMovieTicketByMovieIdAndShowDate(movieId, showDate);
            if (ticketList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(ticketList, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    // get movie ticket by id - Nhung HTC
    @GetMapping("api/employee/saleTicket/movieTicket/{movieTicketId}")
    public ResponseEntity<MovieTicket> findMovieTicketById(@PathVariable Integer movieTicketId) {
        try {
            MovieTicket movieTicket = movieTicketService.findMovieTicketById(movieTicketId);
            return new ResponseEntity<>(movieTicket, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Method: get movie ticket by select - NHungHTC
    @GetMapping("api/employee/saleTicket/movieTicket/{movieId}/{showDate}/{showTimeId}")
    public ResponseEntity<MovieTicket> findMovieTicketById(@PathVariable Integer movieId, @PathVariable String showDate, @PathVariable Integer showTimeId) {
        try {
            MovieTicket movieTicket = movieTicketService.findMovieTicketBySelect(movieId, showDate, showTimeId);
            return new ResponseEntity<>(movieTicket, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
