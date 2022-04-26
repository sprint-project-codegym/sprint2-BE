package com.codegym.cinema.controller;

import com.codegym.cinema.entity.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class TicketController_getListBookedTicket {
    @Autowired
    private TicketController ticketController;

    @Test
    public void getListBookedTicket_5() {
        int page = 1;
        int size = 6;

        ResponseEntity<Page<Ticket>> responseEntity
                = this.ticketController.findAllBookedTicketWithPagination(page,size);
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    @Test
    public void getListBookedTicket_6() {
        int page = 0;
        int size = 3;
        ResponseEntity<Page<Ticket>> responseEntity
                = this.ticketController.findAllBookedTicketWithPagination(page, size);

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("bố già",
                responseEntity.getBody().getContent().get(0).getMovieTicket().getMovie().getMovieName());
        Assertions.assertEquals("2022-04-02",
                responseEntity.getBody().getContent().get(0).getCreateTime());
    }
}


