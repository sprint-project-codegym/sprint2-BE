package com.codegym.cinema.service;

import com.codegym.cinema.entity.ShowTime;

import java.util.List;

public interface ShowTimeService {
    /**
     * Author: NhungHTC
     */
    ShowTime findById(Integer id);

    /**
     * Author: NhungHTC
     */
    List<ShowTime> getAllShowTimeByDate(String date);

    /**
     * Author: NhungHTC
     */
    List<ShowTime> getAllShowTimeByDateAndMovie(String date, Integer movieId);

    /**
     * Author: KhoaTM
     */
    List<ShowTime> findAll();
}
