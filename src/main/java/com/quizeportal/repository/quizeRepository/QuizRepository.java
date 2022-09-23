package com.quizeportal.repository.quizeRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizeportal.model.quiz.Category;
import com.quizeportal.model.quiz.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

	public List<Quiz> findByCategory(Category category);

	public List<Quiz> findByActive(Boolean b);

	public List<Quiz> findByCategoryAndActive(Category c, Boolean b);
}
