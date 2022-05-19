package com.codegym.cinema.service.impl;

import com.codegym.cinema.dto.MemberTicketDTO;
import com.codegym.cinema.entity.Ticket;
import com.codegym.cinema.entity.TicketStatus;
import com.codegym.cinema.repository.TicketRepository;
import com.codegym.cinema.service.TicketService;
import com.codegym.cinema.service.TicketStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;


    @Autowired
    private TicketStatusService ticketStatusService;


    @Override
    public Ticket getDetailTicket(Integer id) {
        return ticketRepository.findTicketByTicketId(id);
    }

    @Override
    public void saveTicket(MemberTicketDTO memberTicketDTO) {

        TicketStatus ticketStatus = this.ticketStatusService.findById(1);
        String createTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        ticketRepository.saveTicket(memberTicketDTO.getMovieTicketId(),
                memberTicketDTO.getSeatId(),
                memberTicketDTO.getUserId(),
                ticketStatus.getTicketStatusId(),
                createTime);
    }

    @Override
    public void saveTicketDTO(Integer movieTicketId, Integer userId, Integer seatId) {
        TicketStatus ticketStatus = this.ticketStatusService.findById( 1 );
        String createTime = new SimpleDateFormat( "yyyy-MM-dd" ).format( new Date() );
        ticketRepository.saveTicket( movieTicketId, seatId, userId,
                ticketStatus.getTicketStatusId(), createTime );

    }

    @Override
    public void createTicket(MemberTicketDTO memberTicketDTO) {
        String createTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        memberTicketDTO.setCreateTime( createTime );
        ticketRepository.createTicket( memberTicketDTO.getMovieTicketId(), memberTicketDTO.getSeatId(), memberTicketDTO.getUserId(), memberTicketDTO.getCreateTime(), memberTicketDTO.getTicketStatusId() );
    }
}
