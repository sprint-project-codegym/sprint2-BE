package com.codegym.cinema.repository;

import com.codegym.cinema.entity.RoomSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomSeatRepository extends JpaRepository<RoomSeat,Integer> {
}
