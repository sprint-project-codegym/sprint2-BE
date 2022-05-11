package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.Room;
import com.codegym.cinema.service.RoomService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Override
    public List<Room> findAll() {
        return null;
    }

    @Override
    public Room findById(Integer id) {
        return null;
    }

    @Override
    public List<Room> findAllRoom() {
        return null;
    }

    @Override
    public Page<Room> findAllRoom(Pageable pageable, String roomName) {
        return null;
    }

    @Override
    public Room findRoomById(Integer id) {
        return null;
    }

    @Override
    public void addRoom(Room room) {

    }

    @Override
    public void editRoom(Room room) {

    }

    @Override
    public void deleteRoom(Integer roomId) {

    }

    @Override
    public void checkDup(Room room, Errors errors) {

    }

    @Override
    public List<Room> searchAllRoom(String roomName) {
        return null;
    }

    @Override
    public Page<Room> findAllByRoomName(String roomName, Pageable pageable) {
        return null;
    }
}
