package com.codegym.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberTicketDTO {
    private Integer ticketId;
    private Integer movieTicketId;
    private String username;
    private Integer seatId;
    private String createTime;
    private Integer ticketStatusId;
}
