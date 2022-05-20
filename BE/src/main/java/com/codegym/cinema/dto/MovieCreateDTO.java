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

    //    @NotBlank(message = "Không được để trống!")
    private String movieName;

    //    @NotBlank(message = "Không được để trống!")
    private String startDate;

    //    @NotBlank(message = "Không được để trống!")
    private String endDate;

    //    @NotBlank(message = "Không được để trống!")
    private String actor;

    //    @NotBlank(message = "Không được để trống!")
    private String movieLength;

    //    @NotBlank(message = "Không được để trống!")
    private String movieStudio;

    //    @NotBlank(message = "Không được để trống!")
    private String director;

    //    @NotBlank(message = "Không được để trống!")
    private String trailer;

    //    @NotNull(message = "Không được để trống!")
    private String movieType;
    List<CategoryDTO> movieCategoryList;

    private String description;
    private String poster;
}
