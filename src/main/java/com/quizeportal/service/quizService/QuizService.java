package com.quizeportal.service.quizService;

import java.util.Set;

import com.quizeportal.model.quiz.Quiz;
import com.quizeportal.repository.quizeRepository.QuizRepository;

public interface QuizService {
	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public Set<Quiz> getQuizs();
	
	public Quiz getQuiz(Long quizId);
	
	public void deleteQuiz(Long quizId);
	
	
}
