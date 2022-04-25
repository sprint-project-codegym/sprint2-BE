package com.codegym.cinema.controller;

import com.codegym.cinema.dto.UserCreateDTO;
import com.codegym.cinema.entity.Ward;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class UserController_createUser {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //username = null
    @Test
    void createUser_username_13_1() throws Exception{
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername(null);
        userCreateDTO.setAvatarUrl("image/avatar.jpg");
        userCreateDTO.setBirthday("1990/01/01");
        userCreateDTO.setEmail("nga@gmail.com");
        userCreateDTO.setGender(1);
        userCreateDTO.setIdCard("125678764");
        userCreateDTO.setName("NgaLe");
        userCreateDTO.setPhone("0923456789");

        Ward ward =new Ward();
        ward.setWardId(1);
        userCreateDTO.setWard(ward);

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/signup")
                .content(this.objectMapper.writeValueAsString(userCreateDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is5xxServerError());
    }

    //username = ""
    @Test
    void createUser_username_14() throws Exception{
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("");
        userCreateDTO.setAvatarUrl("image/avatar.jpg");
        userCreateDTO.setBirthday("1990/01/01");
        userCreateDTO.setEmail("nga@gmail.com");
        userCreateDTO.setGender(1);
        userCreateDTO.setIdCard("125678764");
        userCreateDTO.setName("NgaLe");
        userCreateDTO.setPhone("0923456789");

        Ward ward =new Ward();
        ward.setWardId(1);
        userCreateDTO.setWard(ward);

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/signup")
                        .content(this.objectMapper.writeValueAsString(userCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Sai định dạng email
    @Test
    void createUser_username_15_1() throws Exception{
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("lenga37");
        userCreateDTO.setAvatarUrl("image/avatar.jpg");
        userCreateDTO.setBirthday("1990/01/01");
        userCreateDTO.setEmail("ngagmail.com");
        userCreateDTO.setGender(1);
        userCreateDTO.setIdCard("125678764");
        userCreateDTO.setName("NgaLe");
        userCreateDTO.setPhone("0923456789");

        Ward ward =new Ward();
        ward.setWardId(1);
        userCreateDTO.setWard(ward);

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/signup")
                        .content(this.objectMapper.writeValueAsString(userCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Sai định dạng số CMND
    @Test
    void createUser_username_15_2() throws Exception{
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("lenga37");
        userCreateDTO.setAvatarUrl("image/avatar.jpg");
        userCreateDTO.setBirthday("1990/01/01");
        userCreateDTO.setEmail("nga@gmail.com");
        userCreateDTO.setGender(1);
        userCreateDTO.setIdCard("678764");
        userCreateDTO.setName("NgaLe");
        userCreateDTO.setPhone("0923456789");

        Ward ward =new Ward();
        ward.setWardId(1);
        userCreateDTO.setWard(ward);

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/signup")
                        .content(this.objectMapper.writeValueAsString(userCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Sai định dạng số điện thoại
    @Test
    void createUser_username_15_3() throws Exception{
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("lenga37");
        userCreateDTO.setAvatarUrl("image/avatar.jpg");
        userCreateDTO.setBirthday("1990/01/01");
        userCreateDTO.setEmail("nga@gmail.com");
        userCreateDTO.setGender(1);
        userCreateDTO.setIdCard("123678764");
        userCreateDTO.setName("NgaLe");
        userCreateDTO.setPhone("0923456");

        Ward ward =new Ward();
        ward.setWardId(1);
        userCreateDTO.setWard(ward);

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/signup")
                        .content(this.objectMapper.writeValueAsString(userCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //email = null
    @Test
    void createUser_username_13_2() throws Exception{
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("lenga86");
        userCreateDTO.setAvatarUrl("image/avatar.jpg");
        userCreateDTO.setBirthday("1990/01/01");
        userCreateDTO.setEmail(null);
        userCreateDTO.setGender(1);
        userCreateDTO.setIdCard("125678764");
        userCreateDTO.setName("NgaLe");
        userCreateDTO.setPhone("0923456789");

        Ward ward =new Ward();
        ward.setWardId(1);
        userCreateDTO.setWard(ward);

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/signup")
                        .content(this.objectMapper.writeValueAsString(userCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //username < minLength
    @Test
    void createUser_username_16() throws Exception{
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("nga");
        userCreateDTO.setAvatarUrl("image/avatar.jpg");
        userCreateDTO.setBirthday("1990/01/01");
        userCreateDTO.setEmail("nga@gmail.com");
        userCreateDTO.setGender(1);
        userCreateDTO.setIdCard("125678764");
        userCreateDTO.setName("NgaLe");
        userCreateDTO.setPhone("0923456789");

        Ward ward =new Ward();
        ward.setWardId(1);
        userCreateDTO.setWard(ward);

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/signup")
                        .content(this.objectMapper.writeValueAsString(userCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //username < minLength
    @Test
    void createUser_username_17() throws Exception{
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("nganganganga");
        userCreateDTO.setAvatarUrl("image/avatar.jpg");
        userCreateDTO.setBirthday("1990/01/01");
        userCreateDTO.setEmail("nga@gmail.com");
        userCreateDTO.setGender(1);
        userCreateDTO.setIdCard("125678764");
        userCreateDTO.setName("NgaLe");
        userCreateDTO.setPhone("0923456789");

        Ward ward =new Ward();
        ward.setWardId(1);
        userCreateDTO.setWard(ward);

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/signup")
                        .content(this.objectMapper.writeValueAsString(userCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //tất cả đều hợp lệ
    @Test
    void createUser_username_18() throws Exception{
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("LeNga92");
        userCreateDTO.setAvatarUrl("image/avatar.jpg");
        userCreateDTO.setBirthday("1990/01/01");
        userCreateDTO.setEmail("nga12345@gmail.com");
        userCreateDTO.setGender(1);
        userCreateDTO.setIdCard("125678788");
        userCreateDTO.setName("NgaLe");
        userCreateDTO.setPhone("0923456789");

        Ward ward =new Ward();
        ward.setWardId(1);
        userCreateDTO.setWard(ward);

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/signup")
                        .content(this.objectMapper.writeValueAsString(userCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
