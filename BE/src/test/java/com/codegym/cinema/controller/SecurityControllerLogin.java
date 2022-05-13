package com.codegym.cinema.controller;

import com.codegym.cinema.payload.request.ForgotPasswordRequest;
import com.codegym.cinema.payload.request.LoginRequest;
import com.codegym.cinema.payload.request.ResetPasswordRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import sun.rmi.runtime.Log;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityControllerLogin {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void login_18() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("hau");
        loginRequest.setPassword("1234");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/login")
                .content(this.objectMapper.writeValueAsString(loginRequest))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());;
    }

    @Test
    void login_13() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("");
        loginRequest.setPassword("");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/login")
                .content(this.objectMapper.writeValueAsString(loginRequest))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());;
    }

    @Test
    void sendMailToResetPassword_18() throws Exception {
        ForgotPasswordRequest forgotPasswordRequest = new ForgotPasswordRequest();
        forgotPasswordRequest.setEmail("leconghau095@gmail.com");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/send-verification-email")
                .content(this.objectMapper.writeValueAsString(forgotPasswordRequest))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());;
    }

    @Test
    void sendMailToResetPassword_3() throws Exception {
        ForgotPasswordRequest forgotPasswordRequest = new ForgotPasswordRequest();
        forgotPasswordRequest.setEmail("");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/send-verification-email")
                .content(this.objectMapper.writeValueAsString(forgotPasswordRequest))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());;
    }
}
