package com.ucs.edu.Review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ucs.edu.Review.dto.ReviewDTO;
import com.ucs.edu.Review.model.Product;
import com.ucs.edu.Review.repository.ProductRepository;
import com.ucs.edu.Review.service.ProductService;
import com.ucs.edu.Review.service.ReviewsService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ReviewsService reviewServices;
	
	@Autowired
	private ProductService productService;
	
	
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
	
	@RequestMapping("/{id}")
	public String productDetails(@PathVariable("id") Long id,Model model) {
		String name = null;
		System.out.println(id);
		model.addAttribute("product", productService.getProductById(id));
		model.addAttribute("products",productService.getProductList(name));
		model.addAttribute("reviews",reviewServices.getReviewList(id));
		model.addAttribute("review",new ReviewDTO());
		return "admin_product_detail";
	}
	
	@RequestMapping("/review/{id}")
	public String viewReview(Model model,@PathVariable("id")Long id) {
		model.addAttribute("reviews",reviewServices.getReviewList(id));
		return "manage_review";
	}
	@RequestMapping("/review/delete/{id}")
	public String deleteReview(Model model,@PathVariable("id")Long id) {
		reviewServices.deleteReview(id);
		return "redirect:/admin/product_list";
	}
	
	@RequestMapping("/review/search")
	public String searchReview(Model model,@Param("search") String search) {
		model.addAttribute("reviews",reviewServices.getReviewListBySearch(search));
		return "manage_review";
	}
}
