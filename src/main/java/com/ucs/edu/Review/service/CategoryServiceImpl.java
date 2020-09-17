package com.ucs.edu.Review.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucs.edu.Review.dto.CategoryDTO;
import com.ucs.edu.Review.model.Category;
import com.ucs.edu.Review.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public void saveCategory(CategoryDTO categoryDTO) {
		Category category= new Category();
		category.setCat_name(categoryDTO.getCat_name());
		categoryRepository.save(category);	
	}

	@Override
	public List<Category> getCategoryList() {
		return categoryRepository.findAll();
	}

}
