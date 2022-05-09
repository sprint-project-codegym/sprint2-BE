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
public class MovieController_getListSearchMovieWithPagination {
    @Autowired
    private MockMvc mockMvc;

    // get list theo điều kiện search theo name = "null", categoryId = "null",date = "null",showTimeId = "null"
    @Test
    public void getListSearchMovieWithPagination_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/movie/advancedSearch/?q={q}&categoryId={categoryId}&date={date}&showTimeId={showTimeId}", "null", "null", "null", "null"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // get list theo điều kiện search theo name = "", categoryId = "",date = "",showTimeId = ""
    @Test
    public void getListSearchMovieWithPagination_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/movie/advancedSearch/?q={q}&categoryId={categoryId}&date={date}&showTimeId={showTimeId}", "", "", "", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // get list theo điều kiện search theo name = "null"
    @Test
    public void getListSearchMovieWithPagination_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/movie/advancedSearch/?q={q}",  "null"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // get list theo điều kiện search theo categoryId = "null"
    @Test
    public void getListSearchMovieWithPagination_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/movie/advancedSearch/?categoryId={categoryId}", "null"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // get list theo điều kiện search theo date = "null"
    @Test
    public void getListSearchMovieWithPagination_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/movie/advancedSearch/?date={date}", "null"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // get list theo điều kiện search theo showTimeId = "null"
    @Test
    public void getListSearchMovieWithPagination_6() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/movie/advancedSearch/?showTimeId={showTimeId}","null"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //  get list theo điều kiện search name = "Mor"
    @Test
    public void getListSearchMovieWithPagination_7() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/movie/advancedSearch/?q={q}", "Mor"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //  get list theo điều kiện search categoryId = 1
    @Test
    public void getListSearchMovieWithPagination_8() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/movie/advancedSearch/?categoryId={categoryId}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //  get list theo điều kiện search date = "2022-04-13"
    @Test
    public void getListSearchMovieWithPagination_9() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/movie/advancedSearch/?date={date}", "2022-04-13"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //  get list theo điều kiện search showTimeId = 1
    @Test
    public void getListSearchMovieWithPagination_10() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/movie/advancedSearch/?showTimeId={showTimeId}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //  get list theo điều kiện search name = "Love me"
    @Test
    public void getListSearchMovieWithPagination_11() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/movie/advancedSearch/?q={q}", "Love me"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // get list theo điều kiện không nhập trường search
    @Test
    public void getListSearchMovieWithPagination_12() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/movie/advancedSearch"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // get list theo điều kiện search name = "Ward",categoryId=30,date="2022-12-12",showTimeId=30 cả name,categoryId,date,showTimeId không tồn tại trong DB
    @Test
    public void getListSearchMovieWithPagination_13() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/movie/advancedSearch/?q={q}&categoryId={categoryId}&date={date}&showTimeId={showTimeId}", "Ward", 30, "2022-12-12", 30))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // get list theo điều kiện search name = "Ward", name không tồn tại trong DB
    @Test
    public void getListSearchMovieWithPagination_14() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/movie/advancedSearch/?q={q}", "Ward"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // get list theo điều kiện search categoryId=30,categoryId không tồn tại trong DB
    @Test
    public void getListSearchMovieWithPagination_15() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/movie/advancedSearch/?categoryId={categoryId}", 30))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // get list theo điều kiện search date="2022-12-12",date không tồn tại trong DB
    @Test
    public void getListSearchMovieWithPagination_16() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/movie/advancedSearch/?date={date}", "2022-12-12"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // get list theo điều kiện search showTimeId=30 showTimeId không tồn tại trong DB
    @Test
    public void getListSearchMovieWithPagination_17() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/movie/advancedSearch/?showTimeId={showTimeId}", 30))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
