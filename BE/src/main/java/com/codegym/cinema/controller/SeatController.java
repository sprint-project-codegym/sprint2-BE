package com.codegym.cinema.controller;

import com.codegym.cinema.entity.Seat;
import com.codegym.cinema.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/seat")
public class SeatController {

    @Autowired
    private SeatService seatService;

    /**
     * Method: get all seat
     * Author: NhungHTC
     *
     * @return
     */

    @GetMapping("/seat")
    public ResponseEntity<List<Seat>> getListSeat() {
        List<Seat> seatList = seatService.findAllSeat();
        if (seatList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(seatList, HttpStatus.OK);
    }

    /**
     * Method: get seat by id
     * Author: NhungHTC
     *
     * @return
     */

    @GetMapping("/seat/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable int id) {
        return new ResponseEntity<>(this.seatService.findSeatById(id), HttpStatus.OK);
    }

    /**
     * Method: create seat
     * Author: NhungHTC
     *
     * @return
     */

    @PostMapping(value = "/seat/create-seat", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createSeat(@RequestBody Seat seat, BindingResult bindingResult, UriComponentsBuilder ucBuilder) {
        seatService.addSeat(seat);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/room/{id}").buildAndExpand(seat.getSeatId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    /**
     * Author: NhungHTC
     * @param seat
     * @return
     */
    @PutMapping("/seat/edit-seat")
    public ResponseEntity<Void> updateSeat(@RequestBody Seat seat){
        seatService.updateSeat(seat);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
