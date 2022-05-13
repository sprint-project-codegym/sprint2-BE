package com.codegym.cinema.repository;

import com.codegym.cinema.entity.MovieTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import java.util.List;

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

    @Query(value =  "select * from movie_ticket " +
            "where movie_id = ?1 and show_date = ?2 and show_time_id = ?3 ",
            nativeQuery = true)
    MovieTicket getMovieTicket(Integer movieId, String date, Integer showTimeId);


    @Query(value =  "select * from movie_ticket " +
            "where movie_ticket_id = ?1 ", nativeQuery = true)
    MovieTicket getMovieTicketById(Integer movieTicketId);

  //Method: get all movie ticket by id - NhungHTC
    @Query(value = "SELECT * FROM a0321i1_cinema.movie_ticket WHERE movie_ticket.show_date=?1 GROUP BY movie_ticket.movie_id;", nativeQuery = true)
    List<MovieTicket> showAllMovieTicketByShowDate(String showDate);

    //Method: get movie ticket by select - NhungHTC


    //Method: get all movie by ticket by id and show date - NhungHTC

    @Query(value = "SELECT * FROM a0321i1_cinema.movie_ticket WHERE (movie_ticket.movie_id=?1 and movie_ticket.show_date=?2)", nativeQuery = true)
    List<MovieTicket> showAllMovieTicketByMovieIdAndShowDate(Integer movieId, String showDate);

    //Method: get movie ticket by id - NhungHTC
    @Query(value = "SELECT * FROM a0321i1_cinema.movie_ticket WHERE movie_ticket.movie_ticket_id = ?1", nativeQuery = true)
    MovieTicket findMovieTicketById(Integer movieTicketId);

    //Method: get movie ticket by select - NhungHTC

    @Query(value = "SELECT * FROM a0321i1_cinema.movie_ticket WHERE (movie_ticket.movie_id=?1 and movie_ticket.show_date=?2 and movie_ticket.show_time_id = ?3)", nativeQuery = true)
    MovieTicket showAllMovieTicketBySelect(Integer movieId, String showDate, Integer showTimeId);

    @Modifying
    @Query(value = "SELECT * FROM movie_ticket " +
            "where show_date = ?1", nativeQuery = true)
    List<MovieTicket> findAllMovieTicketByDate(String showDate);

}

