package com.codegym.cinema.dto;

import lombok.Data;

@Data
public class AccountDTO {
    private String username;
    private String newPassword;
    private String oldPassword;
}
