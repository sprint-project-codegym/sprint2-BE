package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.MovieTicket;
import com.codegym.cinema.repository.MovieTicketRepository;
import com.codegym.cinema.service.MovieTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieTicketServiceImpl implements MovieTicketService {

    @Autowired
    MovieTicketRepository movieTicketRepository;

    @Override
    public MovieTicket getDetailMovieTicket(Integer id) {
        return movieTicketRepository.findMovieTicketByMovieTicketId(id);
    }
}
