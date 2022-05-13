package com.codegym.cinema.controller;

import com.codegym.cinema.entity.RoomSeat;
import com.codegym.cinema.service.RoomSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/roomSeat")
public class RoomSeatController {


    @Autowired
    private RoomSeatService roomSeatService;

    // Method: getAllSeat() - NhungHTC
    @GetMapping("/getAllSeat/{roomId}")
    public ResponseEntity<List<RoomSeat>> getAllSeat(@PathVariable(name = "roomId") Integer roomId) {
        List<RoomSeat> listRoomSeat = roomSeatService.findAllByRoomId(roomId);
        if (listRoomSeat.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listRoomSeat, HttpStatus.OK);

    }

}
