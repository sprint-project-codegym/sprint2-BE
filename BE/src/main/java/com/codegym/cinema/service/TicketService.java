package com.codegym.cinema.service;

import com.codegym.cinema.dto.MemberTicketDTO;
import com.codegym.cinema.entity.Ticket;


public interface TicketService {
    Ticket getDetailTicket(Integer id);

    /**
     * author : NhungHTC
     * @param memberTicketDTO : a MemberTicketDTO object
     */
    void saveTicket(MemberTicketDTO memberTicketDTO);

    void saveTicketDTO(Integer movieTicketId, Integer userId, Integer seatId);

    void createTicket(MemberTicketDTO memberTicketDTO);


}
