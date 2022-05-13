package com.codegym.cinema.service.impl;
import com.codegym.cinema.entity.TicketStatus;
import com.codegym.cinema.repository.TicketStatusRepository;
import com.codegym.cinema.service.TicketStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketStatusServiceImpl implements TicketStatusService {

    @Autowired
    private TicketStatusRepository ticketStatusRepository;

    @Override
    public List<TicketStatus> findAll() {
        return ticketStatusRepository.findAll();
    }

    @Override
    public TicketStatus findById(Integer ticketStatusId) {
        return ticketStatusRepository.findById(ticketStatusId).orElse(null);
    }
}
