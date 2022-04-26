package com.codegym.cinema.repository;

import com.codegym.cinema.entity.MovieTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieTicketRepository extends JpaRepository<MovieTicket,Integer> {
    @Query(value = "select * from movie_ticket \n" +
            "inner join movie on movie_ticket.movie_id = movie.movie_id\n" +
            "inner join show_time on movie_ticket.show_time_id = show_time.show_time_id\n" +
            "inner join room on movie_ticket.room_id = room.room_id\n" +
            "inner join ticket on movie_ticket.movie_ticket_id = ticket.movie_ticket_id\n" +
            "inner join `user` on ticket.user_id = `user`.user_id\n" +
            "inner join seat on ticket.seat_id = seat.seat_id\n" +
            "inner join `row` on seat.row_id = `row`.row_id\n" +
            "inner join `column` on seat.column_id = `column`.column_id\n" +
            "where movie_ticket.movie_ticket_id = ?1", nativeQuery = true)
    MovieTicket findMovieTicketByMovieTicketId(Integer id);
}
