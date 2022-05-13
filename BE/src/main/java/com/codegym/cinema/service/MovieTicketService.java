package com.codegym.cinema.service;

import com.codegym.cinema.entity.MovieTicket;

import java.util.List;

public interface MovieTicketService {

    MovieTicket getDetailMovieTicket(Integer id);
    //    NhungHTC

    MovieTicket getMovieTicket(Integer movieId, String date, Integer showTimeId);

    MovieTicket getMovieTicketById(Integer movieTicketId);

    List<MovieTicket> showAllMovieTicketByShowDate(String showDate);

    List<MovieTicket> showAllMovieTicketByMovieIdAndShowDate(Integer movieId, String showDate);

    MovieTicket findMovieTicketById(Integer movieTicketId);

    MovieTicket findMovieTicketBySelect(Integer movieId, String showDate, Integer showTimeId);

    List<MovieTicket> findAllByDate(String showDate);
}
