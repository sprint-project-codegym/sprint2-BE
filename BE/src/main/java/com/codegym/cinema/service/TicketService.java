package com.codegym.cinema.service;

import com.codegym.cinema.dto.MemberTicketDTO;
import com.codegym.cinema.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {
    /**
     * author : NhungHTC
     * @param memberTicketDTO : a MemberTicketDTO object
     */
    void saveTicket(MemberTicketDTO memberTicketDTO);

    void saveTicketDTO(Integer movieTicketId, Integer userId, Integer seatId);

    void createTicket(MemberTicketDTO memberTicketDTO);


}
