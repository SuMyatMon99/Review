package com.ucs.edu.Review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ucs.edu.Review.dto.ProductDTO;
import com.ucs.edu.Review.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@GetMapping("/create_product")
	public String createProduct(Model model) {
		model.addAttribute("product", new ProductDTO());
		model.addAttribute("shops", productService.getShopList());
		model.addAttribute("brands", productService.getBrandList());
		model.addAttribute("categories", productService.getCategoryList());
		return "create_product";
	}
	@PostMapping("/save_product")
	public String saveProduct(@ModelAttribute ("product") ProductDTO productDTO, Model model) throws Exception {
		productService.SaveProduct(productDTO);
		model.addAttribute("products", productService.getProductList());
		return "product_list";
	}
	
	@GetMapping("/product_list")
	public String showProductList(Model model) {
		model.addAttribute("products", productService.getProductList());
		return "product_list";
	}
	@GetMapping("/products/{name}")
	public String showProduct(Model model) {
		model.addAttribute("products", productService.getProductList());
		return "product_list";
	}
	/*@GetMapping("/register")
	public String create_register(Model model) {
		return "register";
	}
	@GetMapping("/login")
	public String login_user(Model model) {
		return "login";
	}
	*/
	
	@GetMapping("/blog-details")
	public String showBolgDetails(Model model) {
		return "blog-details";
	}
	
	@GetMapping("/faq")
	public String showFAQ(Model model) {
		return "faq";
	}
}
