package com.codegym.cinema.service;

import com.codegym.cinema.entity.District;

import java.util.List;

public interface DistrictService {
    List<District> findAllDistrictByProvinceId(Integer provinceId);
}