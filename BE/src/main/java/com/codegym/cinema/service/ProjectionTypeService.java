package com.codegym.cinema.service;

import com.codegym.cinema.entity.ProjectionType;

import java.util.List;

public interface ProjectionTypeService {
    List<ProjectionType> findAll();

    ProjectionType findById(Integer id);
}
