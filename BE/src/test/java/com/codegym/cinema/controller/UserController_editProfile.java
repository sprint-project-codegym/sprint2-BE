package com.codegym.cinema.controller;

import com.codegym.cinema.entity.*;
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
public class UserController_editProfile {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //id = null
    @Test
    public void editProfile_id_19() throws Exception {
        Account account = new Account();
        account.setUsername("luan123");
        account.setAccountStatus("1");
        account.setPassword("12345");
        account.setPoint("100");
        account.setRegisterDate("2022-04-04");

        Province province = new Province();
        province.setProvinceId(48);
        province.setProvinceName("Đà Nẵng");

        District district = new District();
        district.setDistrictId(492);
        district.setDistrictName("Hải Châu");
        district.setProvince(province);

        Ward ward = new Ward();
        ward.setWardId(20227);
        ward.setWardName("Thanh Bình");
        ward.setDistrict(district);

        User user = new User();
        user.setUserId(null);
        user.setAvatarUrl("https://www.pngitem.com/pimgs/m/560-5603874_product-image-logo-avatar-minimalist-flat-line-hd.png");
        user.setBirthday("2000-01-17");
        user.setEmail("thanhluan17@gmail.com");
        user.setGender(1);
        user.setIdCard("212464789");
        user.setName("Luân");
        user.setPhone("0383422212");
        user.setAccount(account);
        user.setWard(ward);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/member/editUser").content(this.objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // avatarUrl = null
    @Test
    public void editProfile_avatarUrl_19() throws Exception {
        Account account = new Account();
        account.setUsername("luan123");
        account.setAccountStatus("1");
        account.setPassword("12345");
        account.setPoint("100");
        account.setRegisterDate("2022-04-04");

        Province province = new Province();
        province.setProvinceId(48);
        province.setProvinceName("Đà Nẵng");

        District district = new District();
        district.setDistrictId(492);
        district.setDistrictName("Hải Châu");
        district.setProvince(province);

        Ward ward = new Ward();
        ward.setWardId(20227);
        ward.setWardName("Thanh Bình");
        ward.setDistrict(district);

        User user = new User();
        user.setUserId(1);
        user.setAvatarUrl(null);
        user.setBirthday("2000-01-17");
        user.setEmail("thanhluan17@gmail.com");
        user.setGender(1);
        user.setIdCard("212464789");
        user.setName("Luân");
        user.setPhone("0383422212");
        user.setAccount(account);
        user.setWard(ward);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/member/editUser").content(this.objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // avatarUrl = blank
    @Test
    public void editProfile_avatarUrl_20() throws Exception {
        Account account = new Account();
        account.setUsername("luan123");
        account.setAccountStatus("1");
        account.setPassword("12345");
        account.setPoint("100");
        account.setRegisterDate("2022-04-04");

        Province province = new Province();
        province.setProvinceId(48);
        province.setProvinceName("Đà Nẵng");

        District district = new District();
        district.setDistrictId(492);
        district.setDistrictName("Hải Châu");
        district.setProvince(province);

        Ward ward = new Ward();
        ward.setWardId(20227);
        ward.setWardName("Thanh Bình");
        ward.setDistrict(district);

        User user = new User();
        user.setUserId(1);
        user.setAvatarUrl("");
        user.setBirthday("2000-01-17");
        user.setEmail("thanhluan17@gmail.com");
        user.setGender(1);
        user.setIdCard("212464789");
        user.setName("Luân");
        user.setPhone("0383422212");
        user.setAccount(account);
        user.setWard(ward);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/member/editUser").content(this.objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //birthday = null
    @Test
    public void editProfile_birthday_19() throws Exception {
        Account account = new Account();
        account.setUsername("luan123");
        account.setAccountStatus("1");
        account.setPassword("12345");
        account.setPoint("100");
        account.setRegisterDate("2022-04-04");

        Province province = new Province();
        province.setProvinceId(48);
        province.setProvinceName("Đà Nẵng");

        District district = new District();
        district.setDistrictId(492);
        district.setDistrictName("Hải Châu");
        district.setProvince(province);

        Ward ward = new Ward();
        ward.setWardId(20227);
        ward.setWardName("Thanh Bình");
        ward.setDistrict(district);

        User user = new User();
        user.setUserId(1);
        user.setAvatarUrl("https://www.pngitem.com/pimgs/m/560-5603874_product-image-logo-avatar-minimalist-flat-line-hd.png");
        user.setBirthday(null);
        user.setEmail("thanhluan17@gmail.com");
        user.setGender(1);
        user.setIdCard("212464789");
        user.setName("Luân");
        user.setPhone("0383422212");
        user.setAccount(account);
        user.setWard(ward);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/member/editUser").content(this.objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //birthday = blank
    @Test
    public void editProfile_birthday_20() throws Exception {
        Account account = new Account();
        account.setUsername("luan123");
        account.setAccountStatus("1");
        account.setPassword("12345");
        account.setPoint("100");
        account.setRegisterDate("2022-04-04");

        Province province = new Province();
        province.setProvinceId(48);
        province.setProvinceName("Đà Nẵng");

        District district = new District();
        district.setDistrictId(492);
        district.setDistrictName("Hải Châu");
        district.setProvince(province);

        Ward ward = new Ward();
        ward.setWardId(20227);
        ward.setWardName("Thanh Bình");
        ward.setDistrict(district);

        User user = new User();
        user.setUserId(1);
        user.setAvatarUrl("https://www.pngitem.com/pimgs/m/560-5603874_product-image-logo-avatar-minimalist-flat-line-hd.png");
        user.setBirthday("");
        user.setEmail("thanhluan17@gmail.com");
        user.setGender(1);
        user.setIdCard("212464789");
        user.setName("Luân");
        user.setPhone("0383422212");
        user.setAccount(account);
        user.setWard(ward);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/member/editUser").content(this.objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //email = null
    @Test
    public void editProfile_email_19() throws Exception {
        Account account = new Account();
        account.setUsername("luan123");
        account.setAccountStatus("1");
        account.setPassword("12345");
        account.setPoint("100");
        account.setRegisterDate("2022-04-04");

        Province province = new Province();
        province.setProvinceId(48);
        province.setProvinceName("Đà Nẵng");

        District district = new District();
        district.setDistrictId(492);
        district.setDistrictName("Hải Châu");
        district.setProvince(province);

        Ward ward = new Ward();
        ward.setWardId(20227);
        ward.setWardName("Thanh Bình");
        ward.setDistrict(district);

        User user = new User();
        user.setUserId(1);
        user.setAvatarUrl("https://www.pngitem.com/pimgs/m/560-5603874_product-image-logo-avatar-minimalist-flat-line-hd.png");
        user.setBirthday("2000-01-17");
        user.setEmail(null);
        user.setGender(1);
        user.setIdCard("212464789");
        user.setName("Luân");
        user.setPhone("0383422212");
        user.setAccount(account);
        user.setWard(ward);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/member/editUser").content(this.objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //email = blank
    @Test
    public void editProfile_email_20() throws Exception {
        Account account = new Account();
        account.setUsername("luan123");
        account.setAccountStatus("1");
        account.setPassword("12345");
        account.setPoint("100");
        account.setRegisterDate("2022-04-04");

        Province province = new Province();
        province.setProvinceId(48);
        province.setProvinceName("Đà Nẵng");

        District district = new District();
        district.setDistrictId(492);
        district.setDistrictName("Hải Châu");
        district.setProvince(province);

        Ward ward = new Ward();
        ward.setWardId(20227);
        ward.setWardName("Thanh Bình");
        ward.setDistrict(district);

        User user = new User();
        user.setUserId(null);
        user.setAvatarUrl("https://www.pngitem.com/pimgs/m/560-5603874_product-image-logo-avatar-minimalist-flat-line-hd.png");
        user.setBirthday("2000-01-17");
        user.setEmail("");
        user.setGender(1);
        user.setIdCard("212464789");
        user.setName("Luân");
        user.setPhone("0383422212");
        user.setAccount(account);
        user.setWard(ward);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/member/editUser").content(this.objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //gender = null
    @Test
    public void editProfile_gender_19() throws Exception {
        Account account = new Account();
        account.setUsername("luan123");
        account.setAccountStatus("1");
        account.setPassword("12345");
        account.setPoint("100");
        account.setRegisterDate("2022-04-04");

        Province province = new Province();
        province.setProvinceId(48);
        province.setProvinceName("Đà Nẵng");

        District district = new District();
        district.setDistrictId(492);
        district.setDistrictName("Hải Châu");
        district.setProvince(province);

        Ward ward = new Ward();
        ward.setWardId(20227);
        ward.setWardName("Thanh Bình");
        ward.setDistrict(district);

        User user = new User();
        user.setUserId(1);
        user.setAvatarUrl("https://www.pngitem.com/pimgs/m/560-5603874_product-image-logo-avatar-minimalist-flat-line-hd.png");
        user.setBirthday("2000-01-17");
        user.setEmail("thanhluan17@gmail.com");
        user.setGender(null);
        user.setIdCard("212464789");
        user.setName("Luân");
        user.setPhone("0383422212");
        user.setAccount(account);
        user.setWard(ward);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/member/editUser").content(this.objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //idCard = null
    @Test
    public void editProfile_idCard_19() throws Exception {
        Account account = new Account();
        account.setUsername("luan123");
        account.setAccountStatus("1");
        account.setPassword("12345");
        account.setPoint("100");
        account.setRegisterDate("2022-04-04");

        Province province = new Province();
        province.setProvinceId(48);
        province.setProvinceName("Đà Nẵng");

        District district = new District();
        district.setDistrictId(492);
        district.setDistrictName("Hải Châu");
        district.setProvince(province);

        Ward ward = new Ward();
        ward.setWardId(20227);
        ward.setWardName("Thanh Bình");
        ward.setDistrict(district);

        User user = new User();
        user.setUserId(1);
        user.setAvatarUrl("https://www.pngitem.com/pimgs/m/560-5603874_product-image-logo-avatar-minimalist-flat-line-hd.png");
        user.setBirthday("2000-01-17");
        user.setEmail("thanhluan17@gmail.com");
        user.setGender(1);
        user.setIdCard(null);
        user.setName("Luân");
        user.setPhone("0383422212");
        user.setAccount(account);
        user.setWard(ward);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/member/editUser").content(this.objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //idCard = blank
    @Test
    public void editProfile_idCard_20() throws Exception {
        Account account = new Account();
        account.setUsername("luan123");
        account.setAccountStatus("1");
        account.setPassword("12345");
        account.setPoint("100");
        account.setRegisterDate("2022-04-04");

        Province province = new Province();
        province.setProvinceId(48);
        province.setProvinceName("Đà Nẵng");

        District district = new District();
        district.setDistrictId(492);
        district.setDistrictName("Hải Châu");
        district.setProvince(province);

        Ward ward = new Ward();
        ward.setWardId(20227);
        ward.setWardName("Thanh Bình");
        ward.setDistrict(district);

        User user = new User();
        user.setUserId(1);
        user.setAvatarUrl("https://www.pngitem.com/pimgs/m/560-5603874_product-image-logo-avatar-minimalist-flat-line-hd.png");
        user.setBirthday("2000-01-17");
        user.setEmail("thanhluan17@gmail.com");
        user.setGender(1);
        user.setIdCard("");
        user.setName("Luân");
        user.setPhone("0383422212");
        user.setAccount(account);
        user.setWard(ward);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/member/editUser").content(this.objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //name = null
    @Test
    public void editProfile_name_19() throws Exception {
        Account account = new Account();
        account.setUsername("luan123");
        account.setAccountStatus("1");
        account.setPassword("12345");
        account.setPoint("100");
        account.setRegisterDate("2022-04-04");

        Province province = new Province();
        province.setProvinceId(48);
        province.setProvinceName("Đà Nẵng");

        District district = new District();
        district.setDistrictId(492);
        district.setDistrictName("Hải Châu");
        district.setProvince(province);

        Ward ward = new Ward();
        ward.setWardId(20227);
        ward.setWardName("Thanh Bình");
        ward.setDistrict(district);

        User user = new User();
        user.setUserId(1);
        user.setAvatarUrl("https://www.pngitem.com/pimgs/m/560-5603874_product-image-logo-avatar-minimalist-flat-line-hd.png");
        user.setBirthday("2000-01-17");
        user.setEmail("thanhluan17@gmail.com");
        user.setGender(1);
        user.setIdCard("212464789");
        user.setName(null);
        user.setPhone("0383422212");
        user.setAccount(account);
        user.setWard(ward);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/member/editUser").content(this.objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //name = blank
    @Test
    public void editProfile_name_20() throws Exception {
        Account account = new Account();
        account.setUsername("luan123");
        account.setAccountStatus("1");
        account.setPassword("12345");
        account.setPoint("100");
        account.setRegisterDate("2022-04-04");

        Province province = new Province();
        province.setProvinceId(48);
        province.setProvinceName("Đà Nẵng");

        District district = new District();
        district.setDistrictId(492);
        district.setDistrictName("Hải Châu");
        district.setProvince(province);

        Ward ward = new Ward();
        ward.setWardId(20227);
        ward.setWardName("Thanh Bình");
        ward.setDistrict(district);

        User user = new User();
        user.setUserId(1);
        user.setAvatarUrl("https://www.pngitem.com/pimgs/m/560-5603874_product-image-logo-avatar-minimalist-flat-line-hd.png");
        user.setBirthday("2000-01-17");
        user.setEmail("thanhluan17@gmail.com");
        user.setGender(1);
        user.setIdCard("212464789");
        user.setName("");
        user.setPhone("0383422212");
        user.setAccount(account);
        user.setWard(ward);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/member/editUser").content(this.objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //phone = null
    @Test
    public void editProfile_phone_19() throws Exception {
        Account account = new Account();
        account.setUsername("luan123");
        account.setAccountStatus("1");
        account.setPassword("12345");
        account.setPoint("100");
        account.setRegisterDate("2022-04-04");

        Province province = new Province();
        province.setProvinceId(48);
        province.setProvinceName("Đà Nẵng");

        District district = new District();
        district.setDistrictId(492);
        district.setDistrictName("Hải Châu");
        district.setProvince(province);

        Ward ward = new Ward();
        ward.setWardId(20227);
        ward.setWardName("Thanh Bình");
        ward.setDistrict(district);

        User user = new User();
        user.setUserId(1);
        user.setAvatarUrl("https://www.pngitem.com/pimgs/m/560-5603874_product-image-logo-avatar-minimalist-flat-line-hd.png");
        user.setBirthday("2000-01-17");
        user.setEmail("thanhluan17@gmail.com");
        user.setGender(1);
        user.setIdCard("212464789");
        user.setName("Luân");
        user.setPhone(null);
        user.setAccount(account);
        user.setWard(ward);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/member/editUser").content(this.objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //phone = blank
    @Test
    public void editProfile_phone_20() throws Exception {
        Account account = new Account();
        account.setUsername("luan123");
        account.setAccountStatus("1");
        account.setPassword("12345");
        account.setPoint("100");
        account.setRegisterDate("2022-04-04");

        Province province = new Province();
        province.setProvinceId(48);
        province.setProvinceName("Đà Nẵng");

        District district = new District();
        district.setDistrictId(492);
        district.setDistrictName("Hải Châu");
        district.setProvince(province);

        Ward ward = new Ward();
        ward.setWardId(20227);
        ward.setWardName("Thanh Bình");
        ward.setDistrict(district);

        User user = new User();
        user.setUserId(1);
        user.setAvatarUrl("https://www.pngitem.com/pimgs/m/560-5603874_product-image-logo-avatar-minimalist-flat-line-hd.png");
        user.setBirthday("2000-01-17");
        user.setEmail("thanhluan17@gmail.com");
        user.setGender(1);
        user.setIdCard("212464789");
        user.setName("Luân");
        user.setPhone("");
        user.setAccount(account);
        user.setWard(ward);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/member/editUser").content(this.objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
