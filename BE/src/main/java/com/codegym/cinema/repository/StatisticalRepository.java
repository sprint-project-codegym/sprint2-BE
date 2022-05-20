package com.codegym.cinema.repository;

import com.codegym.cinema.dto.MemberStatisticalDTO;
import com.codegym.cinema.dto.MovieStatisticalDTO;
import com.codegym.cinema.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatisticalRepository extends JpaRepository<Ticket, Integer> {
    @Query(value = "select movie.movie_name as movieName, " +
            "count(ticket.ticket_id) as ticketQuantity, " +
            "sum(movie_ticket.ticket_price) as revenue " +
            "from ticket " +
            "inner join movie_ticket " +
            "on ticket.movie_ticket_id = movie_ticket.movie_ticket_id " +
            "inner join movie " +
            "on movie_ticket.movie_id = movie.movie_id " +
            "where ticket.ticket_status_id = 2 " +
            "group by movie.movie_id " +
            "order by ticketQuantity desc, revenue desc " +
            "limit ?1", nativeQuery = true)
    List<MovieStatisticalDTO> getTopMovie(int limit);

    @Query(value = "select user.name as name, " +
            "sum(movie_ticket.ticket_price) as totalMoney, " +
            "account.point as point " +
            "from user " +
            "inner join account " +
            "on user.username = account.username " +
            "inner join ticket " +
            "on user.user_id = ticket.user_id " +
            "inner join movie_ticket " +
            "on ticket.movie_ticket_id = movie_ticket.movie_ticket_id " +
            "where ticket.ticket_status_id = 2 " +
            "group by user.user_id " +
            "order by totalMoney desc, point desc " +
            "limit ?1", nativeQuery = true)
    List<MemberStatisticalDTO> getTopMember(int limit);
}
