package com.ucs.edu.Review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ucs.edu.Review.dto.ReviewDTO;
import com.ucs.edu.Review.service.ProductService;
import com.ucs.edu.Review.service.ReviewsService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	private ReviewsService reviewServices;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/{id}")
	public String productDetails(@PathVariable("id") Long id,Model model) {
		String name = null;
		System.out.println(id);
		model.addAttribute("product", productService.getProductById(id));
		model.addAttribute("products",productService.getProductList(name));
		model.addAttribute("reviews",reviewServices.getReviewList(id));
		model.addAttribute("review",new ReviewDTO());
		return "product_detail";
	}

	@GetMapping("/create")
	public String createReview(Model model) {
		model.addAttribute("review", new ReviewDTO());
		return "product_detail";
	}
	@PostMapping("/create")
	public String saveReview(Model model,@ModelAttribute("review")ReviewDTO dto) {
		String name= null;
		reviewServices.saveReview(dto);
		model.addAttribute("products",productService.getProductList(name));
		model.addAttribute("product",productService.getProductById(dto.getProduct_id()));
		model.addAttribute("reviews",reviewServices.getReviewList(dto.getProduct_id()));
		System.out.println(reviewServices.getReviewList(dto.getProduct_id()));
		return "product_detail";
	}
}
