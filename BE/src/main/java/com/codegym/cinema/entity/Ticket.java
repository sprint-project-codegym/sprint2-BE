package com.codegym.cinema.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer ticketId;

    @ManyToOne
    @JoinColumn(name = "movie_ticket_id", referencedColumnName = "movie_ticket_id")
    @JsonBackReference
    private MovieTicket movieTicket;

    @ManyToOne

    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "seat_id")
    private Seat seat;

    @Column(name = "time_create",columnDefinition = "date")
    private String createTime;

    @ManyToOne
    @JoinColumn(name = "ticket_status_id", referencedColumnName = "ticket_status_id")
    private TicketStatus ticketStatus;
}
