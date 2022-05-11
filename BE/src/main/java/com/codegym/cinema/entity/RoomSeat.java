package com.codegym.cinema.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`room_seat`", uniqueConstraints = {
        @UniqueConstraint(name = "ROOM_SEAT_UK", columnNames = {"room_id", "seat_id"})
})
public class RoomSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_seat_id")
    private Integer roomSeatId;

    @Column(name = "seat_status")
    private String seatStatus;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;
}
