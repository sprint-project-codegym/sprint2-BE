package com.codegym.cinema.repository;

import com.codegym.cinema.entity.MovieRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRoomRepository extends JpaRepository<MovieRoom,Integer> {
}
