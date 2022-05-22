package com.codegym.cinema.controller;
import com.codegym.cinema.dto.TicketDTO;
import com.codegym.cinema.entity.Movie;
import com.codegym.cinema.entity.MovieTicket;
import com.codegym.cinema.entity.ShowTime;
import com.codegym.cinema.entity.Ticket;
import com.codegym.cinema.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codegym.cinema.entity.Ticket;
import com.codegym.cinema.entity.User;
import com.codegym.cinema.repository.UserRepository;
import com.codegym.cinema.service.AccountService;
import com.codegym.cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/ticket")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserRepository userRepository;

    //NgaLT get all booked ticket
    @GetMapping("/booked/{username}")
    public ResponseEntity<Page<Ticket>> findAllBookedTicketWithPagination(@RequestParam(defaultValue = "0") int page,
                                                                          @RequestParam(defaultValue = "3") int size,
                                                                          @PathVariable String username) {
        Pageable pageable = PageRequest.of(page, size);
        User user=userRepository.findUserByAccount_Username(username);
        if(user==null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Page<Ticket> tickets = ticketService.findAllBookedTicket(pageable,user.getUserId());
        if (tickets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @Autowired
    private MovieService movieService;

    @Autowired
    private RoomSeatService roomSeatService;

    @Autowired
    private MovieTicketService movieTicketService;

    @Autowired
    private ShowTimeService showTimeService;

    @GetMapping("/booked-ticket-list")
    public ResponseEntity<List<Ticket>> getBookedTicketList(@RequestParam("page") int page) {
        List<Ticket> bookedTicketList = ticketService.findAllByBookedTicket(page);
        if (bookedTicketList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookedTicketList, HttpStatus.OK);
    }
    @GetMapping("/booked-ticket-list-no-page")
    public ResponseEntity<List<Ticket>> getBookedTicketListNoPage() {
        List<Ticket> bookedTicketList = ticketService.findAllByBookedTicketNoPage();
        if (bookedTicketList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookedTicketList, HttpStatus.OK);
    }
    @GetMapping("/booked-ticket-list/get-ticket/{ticketId}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("ticketId") Integer ticketId) {
        Ticket bookedTicket = ticketService.findById(ticketId);
        if (bookedTicket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookedTicket, HttpStatus.OK);
    }
    @GetMapping("/booked-ticket-list/search-ticketId")
    public ResponseEntity<Page<Ticket>> searchByTicketId(@RequestParam(name = "ticketId") Integer ticketId, Pageable pageable) {
        Page<Ticket> bookedTicketList = ticketService.searchByTicketId(ticketId, pageable);
        if (bookedTicketList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookedTicketList, HttpStatus.OK);
    }
    @GetMapping("/booked-ticket-list/search-userId")
    public ResponseEntity<Page<Ticket>> searchByUserId(@RequestParam(name = "userId") Integer userId, Pageable pageable) {
        Page<Ticket> bookedTicketList = ticketService.searchByUserId(userId, pageable);
        if (bookedTicketList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookedTicketList, HttpStatus.OK);
    }
    @GetMapping("/booked-ticket-list/search-idCard")
    public ResponseEntity<Page<Ticket>> searchByIdCard(@RequestParam(name = "idCard") String idCard, Pageable pageable) {
        Page<Ticket> bookedTicketList = ticketService.searchByIdCard(idCard, pageable);
        if (bookedTicketList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookedTicketList, HttpStatus.OK);
    }
    @GetMapping("/booked-ticket-list/search-phone")
    public ResponseEntity<Page<Ticket>> searchByPhone(@RequestParam(name = "phone") String phone, Pageable pageable) {
        Page<Ticket> bookedTicketList = ticketService.searchByPhone(phone, pageable);
        if (bookedTicketList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookedTicketList, HttpStatus.OK);
    }
    @PutMapping("/booked-ticket-list/get-ticket/confirm-ticket/{ticketId}")
    @Transactional
    public ResponseEntity<Ticket> receiveBookedTicket(@PathVariable("ticketId") Integer ticketId) {
        Ticket receivedTicket = ticketService.findById(ticketId);
        if (receivedTicket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.ticketService.receiveBookedTicket(ticketId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

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

    @PostMapping("/createTicketDTO/")
    public ResponseEntity<Void> createTicketDTO(@RequestBody TicketDTO ticketDTO) {
        try {
            this.ticketService.saveTicketDTO( ticketDTO.getMovieTicketId(), ticketDTO.getUsername(), ticketDTO.getSeatId() );
            MovieTicket movieTicket = this.movieTicketService.getMovieTicketById(ticketDTO.getMovieTicketId());
            this.roomSeatService.updateRoomSeatStatus(ticketDTO.getSeatId(), movieTicket.getRoom().getRoomId() );
            return new ResponseEntity<>( HttpStatus.CREATED );
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }
}
