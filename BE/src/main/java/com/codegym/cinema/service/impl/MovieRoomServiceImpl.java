package com.codegym.cinema.service.impl;

import com.codegym.cinema.repository.MovieRoomRepository;
import com.codegym.cinema.service.MovieRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieRoomServiceImpl implements MovieRoomService {
    @Autowired
    MovieRoomRepository movieRoomRepository;

    @Override
    public void createMovieRoom(Integer movieId, Integer room) {
        movieRoomRepository.createMovieRoom(movieId, room);
    }

}
