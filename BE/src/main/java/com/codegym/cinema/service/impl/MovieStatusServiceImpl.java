package com.codegym.cinema.service.impl;

import com.codegym.cinema.repository.MovieStatusRepository;
import com.codegym.cinema.service.MovieStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieStatusServiceImpl implements MovieStatusService {

    @Autowired
    private MovieStatusRepository movieStatusRepository;
}
