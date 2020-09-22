
package com.ucs.edu.Review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ucs.edu.Review.service.CategoryService;

@Controller
public class DefaultController {

	@Autowired 
	private CategoryService categoryService;
	
	@GetMapping("/")
	public String home1(Model model) {
		model.addAttribute("category",categoryService.getCategoryList());
		return "index";
	}

	@GetMapping("/blog-details.htm")
	public String home() {
		return "/blog-details";
	}

	@GetMapping("/blog.htm")
	public String admin() {
		return "/blog";
	}

	@GetMapping("/faq.htm")
	public String user() {
		return "/faq";
	}

	@GetMapping("/about")
	public String about() {
		return "/about";
	}

	@RequestMapping(value = "/403.html")
	public String accessDenied(Model model) {
		return "accessDenied";
	}

}
