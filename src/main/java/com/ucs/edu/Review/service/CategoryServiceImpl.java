package com.ucs.edu.Review.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucs.edu.Review.converter.CategoryConverter;
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
		Category category= CategoryConverter.toEntity(categoryDTO);
		categoryRepository.save(category);	
	}

	@Override
	public List<CategoryDTO> getCategoryList() {
		List<CategoryDTO> dto = categoryRepository.findAll().stream().map(CategoryConverter::toDTO).collect(Collectors.toList());
		return dto;
	}

}
