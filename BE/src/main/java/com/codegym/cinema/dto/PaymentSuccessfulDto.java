package com.codegym.cinema.dto;

import com.codegym.cinema.entity.Movie;
import com.codegym.cinema.entity.Room;
import com.codegym.cinema.entity.ShowTime;
import com.codegym.cinema.entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentSuccessfulDto {
    private String email;
    private Integer movieTicketId;
    private Movie movie;
    private ShowTime showTime;
    private String showDate;
    private Integer ticketPrice;
    private String projectionType;
    private Room room;
    private Set<Ticket> ticketSet;
}
