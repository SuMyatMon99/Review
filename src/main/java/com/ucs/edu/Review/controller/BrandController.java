package com.ucs.edu.Review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ucs.edu.Review.dto.BrandDTO;
import com.ucs.edu.Review.service.BrandService;

@Controller
@RequestMapping("/brand")
public class BrandController {
	@Autowired
	private BrandService brandService;
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/create_brand")
	public String createBrand(Model model) {
		model.addAttribute("brand", new BrandDTO());
		return "create_brand";
	}
	@PostMapping("/save_brand")
	public String saveBrand(@ModelAttribute ("brand") BrandDTO brand, Model model) {
		if(brand!=null) {
		brandService.saveBrand(brand);
		model.addAttribute("brands", brandService.getBrandList());
		return "brand_list";
		}else {
			return "redirect:/create_brand";
		}
	}
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/brand_list")
	public String showBrand(Model model) {
		model.addAttribute("brands", brandService.getBrandList());
		return "brand_list";
	}
}
