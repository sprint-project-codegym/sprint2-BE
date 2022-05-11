package com.codegym.cinema.service;

import com.codegym.cinema.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TicketService {
    List<Ticket> findAllByBookedTicket(int index);

    List<Ticket> findAllByBookedTicketNoPage();

    Ticket findById(Integer ticketId);

    Page<Ticket> searchByTicketId(Integer ticketId, Pageable pageable);

    Page<Ticket> searchByUserId(Integer userId, Pageable pageable);

    Page<Ticket> searchByIdCard(String idCard, Pageable pageable);

    Page<Ticket> searchByPhone(String phone, Pageable pageable);

    void receiveBookedTicket(Integer ticketId);

}
