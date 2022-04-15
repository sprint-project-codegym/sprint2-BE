package com.codegym.cinema.entity;

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

    @Column(name = "room_status", columnDefinition = "varchar(50)")
    private String roomStatus;

}

