package com.codegym.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class MovieTicketToSendMailDto {
    private String ticketId;
    private String email;
    private String username;
    private String roomName;
    private String projectionType;
    private String posterMovie;
    private String movieName;
    private String showDate;
    private String showTime;
    private String seatRow;
    private String seatColumn;
    private String ticketPrice;
}
