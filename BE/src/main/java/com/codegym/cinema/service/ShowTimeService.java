package com.codegym.cinema.service;

import com.codegym.cinema.entity.ShowTime;

import java.util.List;

public interface ShowTimeService {
    ShowTime findById(Integer id);


    List<ShowTime> getAllShowTimeByDate(String date);

    List<ShowTime> getAllShowTimeByDateAndMovie(String date, Integer movieId);

    List<ShowTime> findAll();
}
