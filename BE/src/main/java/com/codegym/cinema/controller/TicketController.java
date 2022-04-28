package com.codegym.cinema.controller;

import com.codegym.cinema.entity.Ticket;
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

    //NgaLT get all booked ticket
    @GetMapping("/booked")
    public ResponseEntity<Page<Ticket>> findAllBookedTicketWithPagination(@RequestParam(defaultValue = "0") int page,
                                                                          @RequestParam(defaultValue = "1") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Ticket> tickets = ticketService.findAllBookedTicket(pageable);
        if (tickets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

}
