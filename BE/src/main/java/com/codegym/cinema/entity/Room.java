package com.codegym.cinema.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "room_name", columnDefinition = "varchar(50)")
    private String roomName;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "status_room_id", referencedColumnName = "status_room_id")
    private StatusRoom statusRoom;

}

