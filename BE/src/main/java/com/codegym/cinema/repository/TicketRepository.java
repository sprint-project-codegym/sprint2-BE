package com.codegym.cinema.repository;

import com.codegym.cinema.entity.MovieTicket;
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


    //PhuocDD
    @Query(value = "select ticket.* from ticket \n" +
            "inner join movie_ticket on ticket.movie_ticket_id = movie_ticket.movie_ticket_id\n" +
            "inner join movie on movie_ticket.movie_id = movie.movie_id\n" +
            "inner join show_time on movie_ticket.show_time_id = show_time.show_time_id\n" +
            "inner join room on movie_ticket.room_id = room.room_id\n" +
            "inner join `user` on ticket.user_id = `user`.user_id\n" +
            "inner join seat on ticket.seat_id = seat.seat_id\n" +
            "inner join `row` on seat.row_id = `row`.row_id\n" +
            "inner join `column` on seat.column_id = `column`.column_id\n" +
            "where ticket.ticket_id = ?1", nativeQuery = true)
    Ticket findTicketByTicketId(Integer id);

}
