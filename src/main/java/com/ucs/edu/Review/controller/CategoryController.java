package com.ucs.edu.Review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ucs.edu.Review.dto.CategoryDTO;
import com.ucs.edu.Review.model.Category;
import com.ucs.edu.Review.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@GetMapping("/create_category")
	public String createCategory(Model model) {
		model.addAttribute("category", new CategoryDTO());
		return "create_category";
	}
	@PostMapping("/save_category")
	public String saveCategory(@ModelAttribute ("category") CategoryDTO category, Model model) {
		categoryService.saveCategory(category);
		model.addAttribute("categories", categoryService.getCategoryList());
		return "category_list";
	}
	
	@GetMapping("/category_list")
	public String showCategory(Model model) {
		model.addAttribute("categories", categoryService.getCategoryList());
		return "category_list";
	}
}
