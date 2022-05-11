package com.codegym.cinema.service;

import com.codegym.cinema.entity.TicketStatus;

import java.util.List;

public interface TicketStatusService {

    List<TicketStatus> findAll();

    TicketStatus findById(Integer ticketStatusId);
}
