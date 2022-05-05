package com.codegym.cinema.service;

import com.codegym.cinema.entity.Ward;

import java.util.List;

public interface WardService {
    List<Ward> findByDistrictId(Integer districtId);
    List<Ward> findWardByDistrictId(Integer wardId);
    List<Ward> findAllByDistrictId(int districtId);
}
