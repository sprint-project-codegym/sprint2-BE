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

    //avatar_url = null
    @Test
    void createUser_username_13_3() throws Exception{
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("lenga86");
        userCreateDTO.setAvatarUrl(null);
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

    //birthday = null
    @Test
    void createUser_username_13_4() throws Exception{
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("lenga86");
        userCreateDTO.setAvatarUrl("image/avatar.jpg");
        userCreateDTO.setBirthday(null);
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

    //gender = null
    @Test
    void createUser_username_13_5() throws Exception{
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("lenga86");
        userCreateDTO.setAvatarUrl("image/avatar.jpg");
        userCreateDTO.setBirthday("1990/01/01");
        userCreateDTO.setEmail("nga@gmail.com");
        userCreateDTO.setGender(null);
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

    //idCard = null
    @Test
    void createUser_username_13_6() throws Exception{
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("lenga86");
        userCreateDTO.setAvatarUrl("image/avatar.jpg");
        userCreateDTO.setBirthday("1990/01/01");
        userCreateDTO.setEmail("nga@gmail.com");
        userCreateDTO.setGender(1);
        userCreateDTO.setIdCard(null);
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

    //name = null
    @Test
    void createUser_username_13_7() throws Exception{
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("lenga86");
        userCreateDTO.setAvatarUrl("image/avatar.jpg");
        userCreateDTO.setBirthday("1990/01/01");
        userCreateDTO.setEmail("nga@gmail.com");
        userCreateDTO.setGender(1);
        userCreateDTO.setIdCard("125678764");
        userCreateDTO.setName(null);
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

    //phone = null
    @Test
    void createUser_username_13_8() throws Exception{
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("lenga86");
        userCreateDTO.setAvatarUrl("image/avatar.jpg");
        userCreateDTO.setBirthday("1990/01/01");
        userCreateDTO.setEmail("nga@gmail.com");
        userCreateDTO.setGender(1);
        userCreateDTO.setIdCard("125678764");
        userCreateDTO.setName("NgaLe");
        userCreateDTO.setPhone(null);

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

    //avatar_url = ""
    @Test
    void createUser_username_14_2() throws Exception{
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("lenga37");
        userCreateDTO.setAvatarUrl("");
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

    //birthday = ""
    @Test
    void createUser_username_14_3() throws Exception{
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("lenga37");
        userCreateDTO.setAvatarUrl("image/avatar.jpg");
        userCreateDTO.setBirthday("");
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

    //email = ""
    @Test
    void createUser_username_14_4() throws Exception{
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("lenga37");
        userCreateDTO.setAvatarUrl("image/avatar.jpg");
        userCreateDTO.setBirthday("1990/01/01");
        userCreateDTO.setEmail("");
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

    //idCard = ""
    @Test
    void createUser_username_14_5() throws Exception{
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("lenga37");
        userCreateDTO.setAvatarUrl("image/avatar.jpg");
        userCreateDTO.setBirthday("1990/01/01");
        userCreateDTO.setEmail("nga@gmail.com");
        userCreateDTO.setGender(1);
        userCreateDTO.setIdCard("");
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

    //name = ""
    @Test
    void createUser_username_14_6() throws Exception{
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("lenga37");
        userCreateDTO.setAvatarUrl("image/avatar.jpg");
        userCreateDTO.setBirthday("1990/01/01");
        userCreateDTO.setEmail("nga@gmail.com");
        userCreateDTO.setGender(1);
        userCreateDTO.setIdCard("125678764");
        userCreateDTO.setName("");
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

    //phone = ""
    @Test
    void createUser_username_14_7() throws Exception{
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("lenga37");
        userCreateDTO.setAvatarUrl("image/avatar.jpg");
        userCreateDTO.setBirthday("1990/01/01");
        userCreateDTO.setEmail("nga@gmail.com");
        userCreateDTO.setGender(1);
        userCreateDTO.setIdCard("125678764");
        userCreateDTO.setName("NgaLe");
        userCreateDTO.setPhone("");

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

    //username > minLength
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
        userCreateDTO.setUsername("LeNga868692");
        userCreateDTO.setAvatarUrl("image/avatar.jpg");
        userCreateDTO.setBirthday("1990/01/01");
        userCreateDTO.setEmail("nga1234567@gmail.com");
        userCreateDTO.setGender(1);
        userCreateDTO.setIdCard("125678768");
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
