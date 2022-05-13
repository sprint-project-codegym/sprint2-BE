package com.codegym.cinema.controller;

import com.codegym.cinema.entity.SeatType;
import com.codegym.cinema.entity.ShowTime;
import com.codegym.cinema.service.SeatTypeService;
import com.codegym.cinema.service.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class SeatTypeController {
    @Autowired
    private ShowTimeService showTimeService;

    @GetMapping("")
    public ResponseEntity<List<ShowTime>> getAllShowtimes() {
        try {
            List<ShowTime> showTimeList = showTimeService.findAll();
            if (showTimeList == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(showTimeList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
