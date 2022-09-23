package com.quizeportal.controller.quizController;

import java.util.List;
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

import com.quizeportal.model.quiz.Category;
import com.quizeportal.model.quiz.Quiz;
import com.quizeportal.service.quizService.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<Quiz> add(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}
	
	@PutMapping("/")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}
	
	@GetMapping("/")
	public Set<Quiz> getQuizs(){
		return this.quizService.getQuizs();
	}
	
	@GetMapping("/{qId}")
	public Quiz getQuiz(@PathVariable("qId") Long qId) {
		return this.quizService.getQuiz(qId);		
	}
	
	@DeleteMapping("/{qId}")
	public void deleete(@PathVariable("qId") Long qId) {
		this.quizService.deleteQuiz(qId);
	}
	
	@GetMapping("/category/{cid}")
	public List<Quiz> getquizzesOfCategory(@PathVariable("cid") Long cid){
		Category category = new Category();
		category.setCid(cid);
		return this.quizService.getQuizzesOfCategory(category);
	}
	
//	get active quizzes
	@GetMapping("/active")
	public List<Quiz> getActive(){
		return this.quizService.getActiveQuizzes();
	}
	
	@GetMapping("/category/active/{cid}")
	public List<Quiz> getActiveQuizzes(@PathVariable("cid") Long cid){
		
		Category category = new Category();
		category.setCid(cid);
		
		return this.quizService.getActiveQuizzesOfCategory(category);
	}
	
	
}
