package com.quizeportal.service.quizService;

import java.util.Set;

import com.quizeportal.model.quiz.Question;
import com.quizeportal.model.quiz.Quiz;

public interface QuestionService {
//	public Quiz addQuiz(Quiz quiz);
	public Question addQuestion(Question question);
//	public Quiz updateQuiz(Quiz quiz);
	public Question updateQuestion(Question question);
//	public Set<Quiz> getQuizs();
	public Set<Question> getQuestions();
//	public Quiz getQuiz(Long quizId);
	public Question getQuestion(Long quesId);
//	public void deleteQuiz(Long quizId);
	public void deleteQuestion(long quesId);
	
	public Set<Question> getQuestionsOfquiz(Quiz quiz);
	
	
}
