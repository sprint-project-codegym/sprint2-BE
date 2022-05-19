package com.codegym.cinema.dto;

import com.codegym.cinema.entity.Category;
import com.codegym.cinema.entity.Movie;
import com.codegym.cinema.entity.MovieCategory;
import com.codegym.cinema.entity.ShowTime;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Set;


@Data

public class MovieCreateDTO {

    private String movieName;
    private String startDate;
    private String endDate;
    private String actor;
    private int movieLength;
    private String movieStudio;
    private String director;
    private String trailer;
    private String movieType;
    private MovieTicketDTO movieTicketDTO;
    List<CategoryDTO> movieCategoryList;
    List<RoomDTO> movieRoomList;
    private String banner;
    private String description;
    private String poster;
}
