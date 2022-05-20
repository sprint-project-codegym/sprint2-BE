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

    private int movieId;

    //    @NotBlank(message = "Không được để trống!")
    private String movieName;

    //    @NotBlank(message = "Không được để trống!")
    private String startDate;

    //    @NotBlank(message = "Không được để trống!")
    private String endDate;

    //    @NotBlank(message = "Không được để trống!")
    private String actor;

    //    @NotBlank(message = "Không được để trống!")
    private int movieLength;

    //    @NotBlank(message = "Không được để trống!")
    private String movieStudio;

    //    @NotBlank(message = "Không được để trống!")
    private String director;

    //    @NotBlank(message = "Không được để trống!")
    private String trailer;

    //    @NotNull(message = "Không được để trống!")
    private String movieType;

    //    @NotNull(message = "Không được để trống!")
    private MovieTicketDTO movieTicketDTO;



    //    @NotNull(message = "Không được để trống!")
    List<CategoryDTO> movieCategoryList;

    //    @NotNull(message = "Không được để trống!")
    List<RoomDTO> movieRoomList;

    private String banner;
    private String description;
    private String poster;
}
