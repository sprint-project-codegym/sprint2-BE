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
class TestMovieController_listMovie {

    @Autowired
    MovieController movieController;

    @Autowired
    private MockMvc mockMvc;

    // list theo name = "null", studio = "null"
    @Test
    void getListMovie_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/movie/manage/list?name={name}&studio={studio}", "null", "null"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // list theo name = "", studio = ""
    @Test
    void getListMovie_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/movie/manage/list?name={name}&studio={studio}", "", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // list theo name = "null"
    @Test
    void getListMovie_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/movie/manage/list?name={name}", "null"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    // list theo studio = "null"
    @Test
    void getListMovie_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/movie/manage/list?studio={studio}",  "null"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // list theo name = "venom"
    @Test
    void getListMovie_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/movie/manage/list?name={name}", "venom"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    // list theo studio = "marvel"
    @Test
    void getListMovie_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/movie/manage/list?studio={studio}", "marvel"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // list theo name = "jujutsu", không tồn tại trong database
    @Test
    void getListMovie_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/movie/manage/list?name={name}", "jujutsu"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // list theo studio = "disney", không tồn tại trong database
    @Test
    void getListMovie_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/movie/manage/list?studio={studio}", "disney"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
