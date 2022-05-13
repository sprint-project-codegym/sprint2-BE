package com.codegym.cinema.controller;
import com.codegym.cinema.entity.Movie;
import com.codegym.cinema.entity.MovieTicket;
import com.codegym.cinema.entity.ShowTime;
import com.codegym.cinema.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private RoomSeatService roomSeatService;

    @Autowired
    private MovieTicketService movieTicketService;

    @Autowired
    private ShowTimeService showTimeService;


    //method : getListMovie() - NhungHTC

    @GetMapping("/listMovie")
    public ResponseEntity<List<Movie>> getListMovie(){
        try {
            List<Movie> listMovie = movieService.findAll();
            if (listMovie.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(listMovie, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

     // method : getListShowTime() - NhungHTC

    @GetMapping("/listShowTime/{date}/{movieId}")
    public ResponseEntity<List<ShowTime>> getListShowTime(@PathVariable(name = "date") String date,
                                                          @PathVariable(name = "movieId") Integer movieId){
        try {
            List<ShowTime> listShowTime = showTimeService.getAllShowTimeByDateAndMovie(date, movieId);
            if (listShowTime.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(listShowTime, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //method : getMovieTicket() - NhungHTC

    @GetMapping("/movieTicket/{movieId}/{date}/{showTimeId}")
    public ResponseEntity<MovieTicket> getMovieTicket(@PathVariable(name = "movieId") Integer movieId,
                                                      @PathVariable(name = "date") String date,
                                                      @PathVariable(name = "showTimeId") Integer showTimeId){
        try {
            MovieTicket movieTicket = this.movieTicketService.getMovieTicket(movieId, date, showTimeId);
            if (movieTicket == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movieTicket, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //method : getMovieTicketById() - NhungHTC

    @GetMapping("/getMovieTicket/{movieTicketId}")
    public ResponseEntity<MovieTicket> getMovieTicketById(@PathVariable(name = "movieTicketId") Integer movieTicketId){
        try {
            MovieTicket movieTicket = this.movieTicketService.getMovieTicketById(movieTicketId);
            if (movieTicket == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movieTicket, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/createTicketDTO/{movieTicketId}/{userId}/{seatId}")
    public ResponseEntity<Void> createTicketDTO(@PathVariable(name = "movieTicketId") Integer movieTicketId,
                                                @PathVariable(name = "userId") Integer userId,
                                                @PathVariable(name = "seatId") Integer seatId) {
        try {
            this.ticketService.saveTicketDTO( movieTicketId, userId, seatId );
            MovieTicket movieTicket = this.movieTicketService.getMovieTicketById( movieTicketId );
            this.roomSeatService.updateRoomSeatStatus( seatId, movieTicket.getRoom().getRoomId() );
            return new ResponseEntity<>( HttpStatus.CREATED );
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

}
