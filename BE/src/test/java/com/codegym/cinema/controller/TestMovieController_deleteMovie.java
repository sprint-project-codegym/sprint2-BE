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
 class TestMovieController_deleteMovie {

    @Autowired
    MovieController movieController;

    @Autowired
    private MockMvc mockMvc;

    // delete movie theo id = "null"
    @Test
     void deleteMovie_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/movie/manage/delete/{id}",  "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // delete movie theo id = ""
    @Test
     void deleteMovie_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/movie/manage/delete/{id}",  ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // delete movie theo id = 2, có trong database
    @Test
     void deleteMovie_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/movie/manage/delete/{id}",  "3"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    // delete movie theo id = 10, không có trong database
    @Test
     void deleteMovie_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/movie/manage/delete/{id}",  "10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
