package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.MovieTicket;
import com.codegym.cinema.repository.MovieTicketRepository;
import com.codegym.cinema.service.MovieTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieTicketServiceImpl implements MovieTicketService {

    @Autowired
    MovieTicketRepository movieTicketRepository;


    @Override
    public MovieTicket getMovieTicket(Integer movieId, String date, Integer showTimeId) {
        return movieTicketRepository.getMovieTicket(movieId, date, showTimeId);
    }


    @Override
    public MovieTicket getMovieTicketById(Integer movieTicketId) {
        return movieTicketRepository.getMovieTicketById(movieTicketId);
    }

    @Override
    public List<MovieTicket> showAllMovieTicketByShowDate(String showDate) {
        return movieTicketRepository.showAllMovieTicketByShowDate(showDate);
    }

    @Override
    public List<MovieTicket> showAllMovieTicketByMovieIdAndShowDate(Integer movieId, String showDate) {
        return movieTicketRepository.showAllMovieTicketByMovieIdAndShowDate(movieId, showDate);
    }

    @Override
    public MovieTicket findMovieTicketById(Integer movieTicketId) {
        return movieTicketRepository.findMovieTicketById(movieTicketId);
    }

    @Override
    public MovieTicket findMovieTicketBySelect(Integer movieId, String showDate, Integer showTimeId) {
        return movieTicketRepository.showAllMovieTicketBySelect(movieId, showDate, showTimeId);
    }

    @Override
    public List<MovieTicket> findAllByDate(String showDate) {
        return movieTicketRepository.findAllMovieTicketByDate(showDate);
    }

}
