package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.ColumnSeat;
import com.codegym.cinema.repository.ColumnSeatRepository;
import com.codegym.cinema.service.ColumnSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColumnSeatServiceImpl implements ColumnSeatService {


    @Autowired
    private ColumnSeatRepository columnRepository;

    @Override
    public List<ColumnSeat> findAllColumn() {
        return columnRepository.findAll();
    }
}
