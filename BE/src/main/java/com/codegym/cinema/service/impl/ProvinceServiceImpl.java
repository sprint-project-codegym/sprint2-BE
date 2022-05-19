package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.Province;
import com.codegym.cinema.repository.ProvinceRepository;
import com.codegym.cinema.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceRepository provinceRepository;
    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }
}
