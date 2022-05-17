package com.codegym.cinema.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/* PhuocDD */

@SpringBootTest
@AutoConfigureMockMvc
public class MovieTicketController_getDetail {
    @Autowired
    private MockMvc mockMvc;

    //Lay theo id = null
    @Test
    public void getDetailMovieTicket_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/movie_ticket/detail/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Lay theo id la rong
    @Test
    public void getDetailMovieTicket_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/movie_ticket/detail/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Lay theo id khong ton tai trong database
    @Test
    public void getDetailMovieTicket_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/movie_ticket/detail/{id}", "11"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    //Lay theo id co ton tai trong database
    @Test
    public void getDetailMovieTicket_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/movie_ticket/detail/{id}", "1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
