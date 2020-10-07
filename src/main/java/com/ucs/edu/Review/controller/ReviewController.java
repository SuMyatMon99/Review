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

import com.ucs.edu.Review.dto.RatingProductUpdateDTO;
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
	public String createReview(Model model,@Param("productId")Long product_id,@Param("comment")String comment,@Param("rating")Float rate) {
		String name=null;
		ReviewDTO dto=new ReviewDTO();
		if(product_id!=null ) {
		dto.setProduct_id(product_id);
		dto.setComment(comment);
		dto.setRating(rate);
		}
		model.addAttribute("review", dto);
		model.addAttribute("products",productService.getProductList(name));
		model.addAttribute("product",productService.getProductById(dto.getProduct_id()));
		model.addAttribute("reviews",reviewServices.getReviewList(dto.getProduct_id()));
		return "product_detail";
	}
	@PostMapping("/create")
	public String saveReview(Model model,@ModelAttribute("review")ReviewDTO dto) throws Exception {
		String name= null;
		reviewServices.saveReview(dto);
		RatingProductUpdateDTO updateDto = new RatingProductUpdateDTO();
		updateDto.setProductId(dto.getProduct_id());
		updateDto.setRating(dto.getRating());
		productService.updateRating(updateDto);
		model.addAttribute("products",productService.getProductList(name));
		model.addAttribute("product",productService.getProductById(dto.getProduct_id()));
		model.addAttribute("reviews",reviewServices.getReviewList(dto.getProduct_id()));
		System.out.println(reviewServices.getReviewList(dto.getProduct_id()));
		return "product_detail";
	}
}
