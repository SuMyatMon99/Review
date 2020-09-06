package com.ucs.edu.Review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ucs.edu.Review.model.Brand;
import com.ucs.edu.Review.repository.BrandRepository;

@Controller
public class BrandController {
	@Autowired
	private BrandRepository brandRepository;
	@GetMapping("/create_brand")
	public String createBrand(Model model) {
		model.addAttribute("brand", new Brand());
		return "create_brand";
	}
	@PostMapping("/save_brand")
	public String saveBrand(@ModelAttribute ("brand") Brand brand, Model model) {
		brandRepository.save(brand);
		model.addAttribute("brands", brandRepository.findAll());
		return "brand_list";
	}
}
