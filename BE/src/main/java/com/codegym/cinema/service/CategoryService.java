package com.codegym.cinema.service;

import com.codegym.cinema.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategory();


    /**
     * Author: KhoaTM
     */
    List<Category> findAll();
}
