package com.ucs.edu.Review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ucs.edu.Review.model.Product;
import com.ucs.edu.Review.repository.ProductRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/product_list")
	public String manageProductsList(Model model){
		model.addAttribute("products",productRepository.findAll());
		return "admin_product_list";
	}
	
	@GetMapping("/product_edit/{product_id}")
	public String editProductList(Model model,@PathVariable Long id) {
		Product product=productRepository.findById(id).get();
		model.addAttribute("product",product);
		return "redirect:/create_product";
	}
	
	@PostMapping("/product_edit")
	public String saveProduct(Model model,@ModelAttribute("product")Product product) {
		productRepository.save(product);
		model.addAttribute("products",productRepository.findAll());
		return "admin_product_list";
	}
	
	@GetMapping("/product_delete/{id}")
	public String deleteProductById(Model model,@PathVariable Long id) {
		Product product=productRepository.findById(id).get();
		productRepository.delete(product);
		model.addAttribute("products",productRepository.findAll());
		return "admin_product_list";
	}
	
	/*
	 * @PostMapping("/product_delete") public String deleteProduct(Model
	 * model,@ModelAttribute("product")Product product) {
	 * productRepository.delete(product);
	 * model.addAttribute("products",productRepository.findAll()); return
	 * "admin_product_list"; }
	 */
}
