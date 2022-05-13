package com.codegym.cinema.repository;

import com.codegym.cinema.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    /**
     * author : NhungHTC
     * function : saveTicket()
     * @param ticketId : id of MovieTicket
     * @param seatId : id of a Seat
     * @param userId : id of a User
     * @param ticketStatusId : id of a TicketStatus
     * @param timeCreate : create Ticket time
     */

    @Modifying
    @Transactional
    @Query( value =  "INSERT INTO ticket(ticketId, seat_id, user_id,ticket_status_id,time_create) " +
            "VALUES (?1, ?2, ?3, ?4, ?5) ",
            nativeQuery = true)
    void saveTicket(Integer ticketId, Integer seatId, Integer userId, Integer ticketStatusId, String timeCreate);

    //creatTicket()
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO cinema_db.ticket(ticket.movie_ticket_id, ticket.seat_id, ticket.user_id, ticket.time_create, ticket.ticket_status_id)\n" +
            "VALUE (?1,?2,?3,?4,?5)", nativeQuery = true)
    void createTicket(Integer movieTicketId, Integer seatId, Integer userId, String timeCreate, Integer ticketStatusId);



}
