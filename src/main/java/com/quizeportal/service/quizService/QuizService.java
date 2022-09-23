package com.quizeportal.service.quizService;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.quizeportal.model.quiz.Category;
import com.quizeportal.model.quiz.Quiz;
import com.quizeportal.repository.quizeRepository.QuizRepository;



public interface QuizService {
	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public Set<Quiz> getQuizs();
	
	public Quiz getQuiz(Long quizId);
	
	public void deleteQuiz(Long quizId);

//	void getQuizzesOfCategory();
	public List<Quiz> getQuizzesOfCategory(Category category);
	
	
	public List<Quiz> getActiveQuizzes();
	public List<Quiz> getActiveQuizzesOfCategory(Category c);


	
	
}
