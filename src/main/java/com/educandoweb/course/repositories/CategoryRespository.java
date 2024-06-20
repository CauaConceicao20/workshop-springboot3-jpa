package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRespository extends JpaRepository<Category, Long> {
}
