package com.codegym.cinema.service.impl;
import com.codegym.cinema.entity.ProjectionType;
import com.codegym.cinema.repository.ProjectionTypeRepository;
import com.codegym.cinema.service.ProjectionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectionTypeServiceImpl implements ProjectionTypeService {

    @Autowired
    private ProjectionTypeRepository projectionTypeRepository;

    @Override
    public List<ProjectionType> findAll() {
        return projectionTypeRepository.findAll();
    }

    @Override
    public ProjectionType findById(Integer id) {
        return projectionTypeRepository.findById(id).orElse(null);
    }
}
