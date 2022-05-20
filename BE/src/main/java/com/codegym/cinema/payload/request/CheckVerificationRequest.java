package com.codegym.cinema.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckVerificationRequest {
    @NotBlank
    private String verificationCode;
}
