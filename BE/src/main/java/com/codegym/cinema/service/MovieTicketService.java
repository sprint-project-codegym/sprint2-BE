package com.codegym.cinema.service;

import com.codegym.cinema.entity.MovieTicket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.Errors;

import java.text.ParseException;
import java.util.List;

public interface MovieTicketService {
    //    NhungHTC

    MovieTicket getMovieTicket(Integer movieId, String date, Integer showTimeId);

    MovieTicket getMovieTicketById(Integer movieTicketId);

    List<MovieTicket> showAllMovieTicketByShowDate(String showDate);

    List<MovieTicket> showAllMovieTicketByMovieIdAndShowDate(Integer movieId, String showDate);


    MovieTicket findMovieTicketById(Integer movieTicketId);


    MovieTicket findMovieTicketBySelect(Integer movieId, String showDate, Integer showTimeId);



    List<MovieTicket> findAllByDate(String showDate);
}
