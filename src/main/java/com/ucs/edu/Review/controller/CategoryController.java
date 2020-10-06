package com.ucs.edu.Review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ucs.edu.Review.dto.CategoryDTO;
import com.ucs.edu.Review.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/create_category")
	public String createCategory(Model model) {
		model.addAttribute("category", new CategoryDTO());
		return "create_category";
	}
	
	@PostMapping("/save_category")
	public String saveCategory(@ModelAttribute ("category") CategoryDTO category, Model model) {
		if(category.getCat_name()!=null) {
		categoryService.saveCategory(category);
		model.addAttribute("categories", categoryService.getCategoryList());
		return "category_list";
		}else {
			return "redirect:/create_category";
		}
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/category_list")
	public String showCategory(Model model) {
		model.addAttribute("categories", categoryService.getCategoryList());
		return "category_list";
	}
	
	@RequestMapping("/category_delete/{id}")
	public String deleteCategoryById(Model model,@PathVariable Long id) {
		categoryService.deleteCategoryById(id);
		model.addAttribute("categories", categoryService.getCategoryList());
		return "category_list";
	}
}
