package com.ucs.edu.Review.service;

import java.util.List;

import com.ucs.edu.Review.dto.CategoryDTO;
import com.ucs.edu.Review.model.Category;

public interface CategoryService {
	public void saveCategory(CategoryDTO categoryDTO);
	
	public List<Category> getCategoryList();
}
