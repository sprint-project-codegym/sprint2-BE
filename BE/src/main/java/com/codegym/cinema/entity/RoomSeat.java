package com.codegym.cinema.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "`room_seat`", uniqueConstraints = {
        @UniqueConstraint(name = "ROOM_SEAT_UK", columnNames = {"room_id", "seat_id"})
})
public class RoomSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_seat_id")
    private Integer roomSeatId;

    @ManyToOne
    @JoinColumn(name = "seat_status_id")
    private SeatStatus seatStatus;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;
}
