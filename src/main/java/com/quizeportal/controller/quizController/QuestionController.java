package com.quizeportal.controller.quizController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizeportal.model.quiz.Question;
import com.quizeportal.model.quiz.Quiz;
import com.quizeportal.service.quizService.QuestionService;
import com.quizeportal.service.quizService.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuizService quizService;

	@PostMapping("/")
	public ResponseEntity<Question> add(@RequestBody Question question) {

		return ResponseEntity.ok(this.questionService.addQuestion(question));

	}

	@PutMapping("/")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
	}

	@GetMapping("/")
	public Set<Question> getAll() {
		return this.questionService.getQuestions();
	}

	@GetMapping("/{questionId}")
	public Question getSingle(@PathVariable("questionId") Long questionId) {
		return this.questionService.getQuestion(questionId);
	}

//	get All qustion of any quiz
	@GetMapping("/quiz/{qId}")
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qId") Long qId) {

//		Quiz quiz = new Quiz();
//		quiz.setqId(qId);
//		Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfquiz(quiz);
//		return ResponseEntity.ok(questionsOfQuiz);

		Quiz quiz = this.quizService.getQuiz(qId);
		Set<Question> questions = quiz.getQuestions();

		List list = new ArrayList(questions);
		if (list.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {

			list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions() + 1));

		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);

	}
	
	
//	get All qustion of any quiz
	@GetMapping("/quiz/all/{qId}")
	public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qId") Long qId) {

		Quiz quiz = new Quiz();
		quiz.setqId(qId);
		Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfquiz(quiz);
		return ResponseEntity.ok(questionsOfQuiz);

	}
	
	

	@DeleteMapping("/{questionId}")
	public void delete(@PathVariable("questionId") Long questionId) {
		this.questionService.deleteQuestion(questionId);
	}

//	eval quiz
	@PostMapping("/eval-quiz")
	public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions) {
		System.out.println(questions);

		Double marksGot = (double) 0;
		Integer correctAnswer = 0;
		Integer attempted = 0;

		for (Question q : questions) {
			System.out.println(q.getGivenAnswer());

			Question question = this.questionService.get(q.getQuesID());

			if (question.getAnswer().equals(q.getGivenAnswer())) {
				correctAnswer++;
				double markSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks()) / questions.size();
				marksGot += markSingle;

			}
			if (q.getGivenAnswer() != null) {
				attempted++;

			}

		}
		
		Map<String, Object> map = Map.of("marksGot",marksGot, "correctAnswers", correctAnswer, "attempted",attempted);
		
		return ResponseEntity.ok(map);
	}

}
