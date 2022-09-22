package com.quizeportal.impl.quizImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizeportal.model.quiz.Question;
import com.quizeportal.model.quiz.Quiz;
import com.quizeportal.repository.quizeRepository.QuestionRepository;
import com.quizeportal.service.quizService.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question addQuestion(Question question) {

		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		return new LinkedHashSet<>( this.questionRepository.findAll());
	}

	@Override
	public Question getQuestion(Long quesId) {
		return this.questionRepository.findById(quesId).get();
	}

	@Override
	public void deleteQuestion(long quesId) {
		this.questionRepository.deleteById(quesId);
	}

	@Override
	public Set<Question> getQuestionsOfquiz(Quiz quiz) {

		return this.questionRepository.findByQuiz(quiz);
	}

}
