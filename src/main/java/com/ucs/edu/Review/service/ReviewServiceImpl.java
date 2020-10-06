package com.ucs.edu.Review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucs.edu.Review.dto.ReviewDTO;
import com.ucs.edu.Review.model.Product;
import com.ucs.edu.Review.model.Review;
import com.ucs.edu.Review.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewsService{

	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private ProductService productService;
	@Autowired
	private CurrentUserService currentUserService;
	
	@Override
	public void saveReview(ReviewDTO dto) {
		if(currentUserService.getCurrentUser()!=null) {
			Long id = (long) 29;
		Product product=productService.getProductById(dto.getProduct_id());
		Review review = new Review();
		review.setComment(dto.getComment());
		review.setRating(dto.getRating());
		review.setProduct(product);
		review.setUser(currentUserService.getCurrentUser());
		reviewRepository.save(review);
		}
	}

	@Override
	public List<Review> getReviewList(Long product_id) {
		return reviewRepository.getReviewListByProductId(product_id);
	}

}
