package com.quizeportal.repository.quizeRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizeportal.model.quiz.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{

}
