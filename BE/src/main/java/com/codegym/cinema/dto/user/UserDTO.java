package com.codegym.cinema.dto.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotBlank(message = "Trường này không được để trống!")
    private String name;

    @NotBlank(message = "Trường này không được để trống!")
    private String birthday;

    @Min(value = 1, message = "Trường này không được để trống!")
    private int gender;

    @NotBlank(message = "Trường này không được để trống!")
    private String email;

    @NotBlank(message = "Trường này không được để trống!")
    private String phone;

    @NotBlank(message = "Trường này không được để trống!")
    private String idCard;

    @NotBlank(message = "Trường này không được để trống!")
    private String avatarUrl;

    @Min(value = 1, message = "Trường này không được để trống!")
    private int wardId;

}
