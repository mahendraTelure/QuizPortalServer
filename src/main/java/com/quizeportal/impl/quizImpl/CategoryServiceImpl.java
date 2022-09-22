package com.quizeportal.impl.quizImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizeportal.model.quiz.Category;
import com.quizeportal.repository.quizeRepository.CategoryRepository;
import com.quizeportal.service.quizService.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category addCategory(Category category) {
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return this.categoryRepository.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		
		return new LinkedHashSet<>( this.categoryRepository.findAll());
	}

	@Override
	public Category getCategory(long category) {
		return this.categoryRepository.findById(category).get();
	}

	@Override
	public void deleteCategory(Long categoryId) {
		this.categoryRepository.deleteById(categoryId);
		
	}
	
}
