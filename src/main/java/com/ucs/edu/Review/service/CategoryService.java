package com.ucs.edu.Review.service;

import java.util.List;

import com.ucs.edu.Review.dto.CategoryDTO;

public interface CategoryService {
	public void saveCategory(CategoryDTO categoryDTO);
	
	public List<CategoryDTO> getCategoryList();
	
	public void deleteCategoryById(Long id);
}
