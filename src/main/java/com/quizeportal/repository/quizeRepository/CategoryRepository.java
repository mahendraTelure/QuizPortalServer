package com.quizeportal.repository.quizeRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizeportal.model.quiz.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
