package com.codegym.cinema.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieController_getDetailMovie {
    @Autowired
    private MockMvc mockMvc;

    // Test item null - 1

    @Test
    public void getDetailMovie_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/movie/detail/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test item empty - 2

    @Test
    public void getDetailMovie_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/movie/detail/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test item has id not exist in DB - 3

    @Test
    public void getDetailMovie_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/movie/detail/{id}", "2"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test item has id exist in DB - 4

    @Test
    public void getDetailMovie_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/movie/detail/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
