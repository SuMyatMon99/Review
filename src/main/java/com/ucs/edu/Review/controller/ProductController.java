package com.ucs.edu.Review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ucs.edu.Review.model.Product;
import com.ucs.edu.Review.repository.BrandRepository;
import com.ucs.edu.Review.repository.CategoryRepository;
import com.ucs.edu.Review.repository.ProductRepository;
import com.ucs.edu.Review.repository.ShopRepository;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ShopRepository shopRepository;
	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@GetMapping("/create_product")
	public String createProduct(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("shops", shopRepository.findAll());
		model.addAttribute("brands", brandRepository.findAll());
		model.addAttribute("categories", categoryRepository.findAll());
		return "create_product";
	}
	@PostMapping("/save_product")
	public String saveProduct(@ModelAttribute ("product") Product product, Model model) {
		productRepository.save(product);
		model.addAttribute("products", productRepository.findAll());
		return "product_list";
	}
}
