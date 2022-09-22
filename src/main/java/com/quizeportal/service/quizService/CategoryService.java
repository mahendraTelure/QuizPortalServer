package com.quizeportal.service.quizService;

import java.util.Set;

import com.quizeportal.model.quiz.Category;

public interface CategoryService {
	public Category addCategory(Category category);

	public Category updateCategory(Category category);

	public Set<Category> getCategories();

	public Category getCategory(long category);

	public void deleteCategory(Long categoryId);

}
