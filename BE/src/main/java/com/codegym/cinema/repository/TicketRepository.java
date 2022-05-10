package com.codegym.cinema.repository;

import com.codegym.cinema.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {

    // NgaLT get all booked ticket
//    @Query(value = "select user.user_id, ticket.time_create, ticket.ticket_status, movie_ticket.ticket_price, movie.movie_name " +
//            "from user " +
//            "inner join ticket on user.user_id = ticket.user_id " +
//            "inner join movie_ticket on ticket.movie_ticket_id = movie_ticket.movie_ticket_id " +
//            "inner join movie on movie_ticket.movie_id = movie.movie_id", nativeQuery = true )
//    @Query(value = "select * from ticket where ticket.ticket_status in ("+"'Đã nhận vé'"+","+"'Đợi nhận vé'"+")", nativeQuery = true )
//    Page<Ticket> findAllBookedTicket(Pageable pageable);

    @Query(value = "select * from ticket where ticket.ticket_status_id in ("+"'1'"+","+"'2'"+") order by ticket.time_create ASC", nativeQuery = true )
    Page<Ticket> findAllBookedTicket(Pageable pageable);
}
