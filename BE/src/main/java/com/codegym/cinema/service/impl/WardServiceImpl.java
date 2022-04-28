package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.Ward;
import com.codegym.cinema.repository.WardRepository;
import com.codegym.cinema.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardServiceImpl implements WardService {
    @Autowired
    private WardRepository wardRepository;

    @Override
    public List<Ward> findByDistrictId(Integer districtId) {
        return wardRepository.findByDistrictId(districtId);
    }

    @Override
    public List<Ward> findAllByDistrictId(int districtId) {
        return wardRepository.findAllByDistrictId(districtId);
    }
}
