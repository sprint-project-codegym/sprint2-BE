package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.Category;
import com.codegym.cinema.repository.CategoryRepository;
import com.codegym.cinema.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    /**
     * Author: AnhNDH
     */
    @Override
    public List<Category> getCategory() {
        return categoryRepository.getCategory();
    }

    /**
     * Author: KhoaTM
     */
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
