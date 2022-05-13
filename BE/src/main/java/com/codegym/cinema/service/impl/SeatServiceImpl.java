package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.Seat;
import com.codegym.cinema.service.SeatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {
    @Override
    public List<Seat> findAllSeat() {
        return null;
    }

    @Override
    public Seat findSeatById(Integer id) {
        return null;
    }

    @Override
    public void addSeat(Seat seat) {

    }

    @Override
    public void updateSeat(Seat seat) {

    }

    @Override
    public Seat findSeatByColumn_ColumnIdAndRow_RowId(Integer column_columnId, Integer row_rowId) {
        return null;
    }

    @Override
    public void createSeatBySeatType(Integer seatTypeId, Integer seatId) {

    }
}
