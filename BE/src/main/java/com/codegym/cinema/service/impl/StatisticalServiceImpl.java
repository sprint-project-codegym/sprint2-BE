package com.codegym.cinema.service.impl;

import com.codegym.cinema.dto.MemberStatisticalDTO;
import com.codegym.cinema.dto.MovieStatisticalDTO;
import com.codegym.cinema.repository.StatisticalRepository;
import com.codegym.cinema.service.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticalServiceImpl implements StatisticalService {
    @Autowired
    StatisticalRepository statisticalRepository;

    @Override
    public List<MovieStatisticalDTO> getTopMovie(int limit) {
        return statisticalRepository.getTopMovie(limit);
    }

    @Override
    public List<MemberStatisticalDTO> getTopMember(int limit) {
        return statisticalRepository.getTopMember(limit);
    }
}
