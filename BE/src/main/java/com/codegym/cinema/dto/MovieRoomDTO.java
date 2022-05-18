package com.codegym.cinema.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MovieRoomDTO {
    @NotBlank(message = "Không dược để trống")
    private String movieRoom;
}
