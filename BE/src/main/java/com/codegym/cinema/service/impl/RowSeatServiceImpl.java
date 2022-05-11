package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.RowSeat;
import com.codegym.cinema.repository.RowSeatRepository;
import com.codegym.cinema.service.RowSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RowSeatServiceImpl implements RowSeatService {
    @Autowired
    private RowSeatRepository rowRepository;

    @Override
    public List<RowSeat> findAllRow() {
        return rowRepository.findAll();
    }
}
