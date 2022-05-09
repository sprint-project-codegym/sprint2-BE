package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.ShowTime;
import com.codegym.cinema.repository.ShowTimeRepository;
import com.codegym.cinema.service.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowTimeServiceImpl implements ShowTimeService {

    @Autowired
    private ShowTimeRepository showTimeRepository;

    /**
     * Author: KhoaTM
     */
    @Override
    public List<ShowTime> findAll() {
        return showTimeRepository.findAll();
    }
}
