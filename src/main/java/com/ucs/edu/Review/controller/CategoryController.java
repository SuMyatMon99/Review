package com.ucs.edu.Review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ucs.edu.Review.model.Category;
import com.ucs.edu.Review.repository.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;
	@GetMapping("/create_category")
	public String createCategory(Model model) {
		model.addAttribute("category", new Category());
		return "create_category";
	}
	@PostMapping("/save_category")
	public String saveCategory(@ModelAttribute ("category") Category category, Model model) {
		categoryRepository.save(category);
		model.addAttribute("categories", categoryRepository.findAll());
		return "category_list";
	}
	
	@GetMapping("/category_list")
	public String showCategory(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		return "category_list";
	}
}
