package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.Ticket;
import com.codegym.cinema.repository.TicketRepository;
import com.codegym.cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> findAllByBookedTicket(int index) {
        return ticketRepository.findAllByBookedTicket(index);
    }

    @Override
    public List<Ticket> findAllByBookedTicketNoPage() {
        return ticketRepository.findAllByBookedTicketNoPage();
    }

    @Override
    public Ticket findById(Integer ticketId) {
        return ticketRepository.findById(ticketId).orElse(null);
    }

    @Override
    public Page<Ticket> searchByTicketId(Integer ticketId, Pageable pageable) {
        return ticketRepository.searchByTicketId(ticketId, pageable);
    }

    @Override
    public Page<Ticket> searchByUserId(Integer userId, Pageable pageable) {
        return ticketRepository.searchByUserId(userId, pageable);
    }

    @Override
    public Page<Ticket> searchByIdCard(String idCard, Pageable pageable) {
        return ticketRepository.searchByIdCard(idCard, pageable);
    }

    @Override
    public Page<Ticket> searchByPhone(String phone, Pageable pageable) {
        return ticketRepository.searchByPhone(phone, pageable);
    }

    @Override
    public void receiveBookedTicket(Integer ticketId) {
        ticketRepository.receiveBookedTicket(ticketId);
    }
}
