package com.educandoweb.course.service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRespository categoryRespository;

    public List<Category> findAll() {
        return categoryRespository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> category = categoryRespository.findById(id);
        return category.get();
    }

}
