package com.codegym.cinema.service;

import com.codegym.cinema.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {

    //    NgaLT get all booked ticket
    Page<Ticket> findAllBookedTicket(Pageable pageable, Integer userId);

}