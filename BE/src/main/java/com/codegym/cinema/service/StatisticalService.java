package com.codegym.cinema.service;

import com.codegym.cinema.dto.MemberStatisticalDTO;
import com.codegym.cinema.dto.MovieStatisticalDTO;

import java.util.List;

public interface StatisticalService {
    List<MovieStatisticalDTO> getTopMovie(int limit);

    List<MemberStatisticalDTO> getTopMember(int limit);

}
