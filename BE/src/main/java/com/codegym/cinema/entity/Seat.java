package com.codegym.cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "`seat`",
        uniqueConstraints = {
                @UniqueConstraint(name = "SEAT_UK", columnNames = "seat_id")
        })
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id", columnDefinition = "int")
    private Integer seatId;

    @ManyToOne
    @JoinColumn(name = "row_id")
    private RowSeat row;

    @ManyToOne
    @JoinColumn(name = "column_id")
    private ColumnSeat column;

    @Column(name = "seat_type", columnDefinition = "varchar(50)")
    private String seatType;

    @OneToMany(mappedBy = "seat")
    @JsonIgnore
    private Set<Ticket> ticketSet;
}