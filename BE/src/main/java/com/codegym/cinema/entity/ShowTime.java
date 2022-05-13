package com.codegym.cinema.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "show_time")
public class ShowTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_time_id")
    private Integer showTimeId;

    @Column(name = "show_time", columnDefinition = "VARCHAR(50)")
    private String showTime;
}

