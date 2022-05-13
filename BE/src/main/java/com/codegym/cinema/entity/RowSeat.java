package com.codegym.cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "`row`")
public class RowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "row_id")
    private Integer rowId;

    @Column(name = "row_name", columnDefinition = "varchar(20)")
    private String rowName;

    @OneToMany(mappedBy = "row")
    @JsonIgnore
    private Set<Seat> seatSet;
}
