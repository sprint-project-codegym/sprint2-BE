package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.Ticket;
import com.codegym.cinema.repository.TicketRepository;
import com.codegym.cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Page<Ticket> findAllBookedTicket(Pageable pageable,Integer userId) {
        return ticketRepository.findAllBookedTicket(pageable,userId);
    }
}