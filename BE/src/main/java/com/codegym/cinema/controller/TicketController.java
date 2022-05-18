package com.codegym.cinema.controller;

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

}