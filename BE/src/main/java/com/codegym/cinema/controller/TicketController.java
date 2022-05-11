package com.codegym.cinema.controller;

import com.codegym.cinema.entity.Ticket;
import com.codegym.cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping("/booked-ticket-list/")
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
}
