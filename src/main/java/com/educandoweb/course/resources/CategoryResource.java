package com.educandoweb.course.resources;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/returnAll")
    public ResponseEntity<List<Category>> findAllCategory() {
        var list = categoryService.findAll();

       return ResponseEntity.ok().body(list);
    }

    @GetMapping("/returnById/{id}")
    public ResponseEntity<Category> findByIdCategory(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        return ResponseEntity.ok().body(category);
    }

}
