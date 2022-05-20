package com.codegym.cinema.dto;

import com.codegym.cinema.entity.Ward;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserDTO {
    private String  avatarUrl;

    @NotBlank(message = "Ngày sinh không được để trống!")
    @NotEmpty(message = "Vui lòng nhập ngày sinh")
    private String birthday;

    @NotBlank(message = "Email không được để trống!")
//    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotNull(message = "Giới tính không được để trống!")
    private Integer gender;

    @NotBlank(message = "Số CMND không được để trống!")
//    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$", message = "Số CMND không đúng định dạng!")
    private String idCard;

    @NotBlank(message = "Họ tên không được để trống!")
    private String name;

    @NotBlank(message = "Số điện thoại không được để trống!")
//    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$", message = "Số điện thoại không đúng định dạng!")
    private String phone;

    @NotBlank(message = "Tên tài khoản không được để trống")
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,45}$" , message = "Tên tài khoản tối thiểu 6 kí tự gồm cả chữ và số")
    private String username;

    @NotNull(message = "Địa chỉ không được để trống!")
    private Ward ward;

    @NotBlank(message = "Mật khẩu không được để trống!")
//    @Size(min = 6,message = "Nhập mật khẩu tối thiểu 6 ký tự.")
    private String password;
}