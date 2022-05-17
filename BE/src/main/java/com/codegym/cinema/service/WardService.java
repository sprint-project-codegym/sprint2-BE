package com.codegym.cinema.service;

import com.codegym.cinema.entity.Ward;

import java.util.List;

public interface WardService {
    List<Ward> findAll();

    List<Ward> findByDistrictId(int districtId);
}
