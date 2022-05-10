package com.codegym.cinema.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer ticketId;

    @ManyToOne
    @JoinColumn(name = "movie_ticket_id", referencedColumnName = "movie_ticket_id")
    private MovieTicket movieTicket;

    @ManyToOne

    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "seat_id")
    private Seat seat;

    @Column(name = "time_create", columnDefinition = "date")
    private String createTime;

//    @Column(name = "ticket_status", columnDefinition = "varchar(50)")
//    private String ticketStatus;

    @ManyToOne
    @JoinColumn(name = "ticket_status_id", referencedColumnName = "ticket_status_id")
    private TicketStatus ticketStatus;
}
