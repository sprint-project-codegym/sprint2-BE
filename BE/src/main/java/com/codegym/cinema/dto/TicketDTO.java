package com.codegym.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TicketDTO {
   Integer movieTicketId;
   String username;
   Integer seatId;
}
