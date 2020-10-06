package com.ucs.edu.Review.service;

import java.util.List;

import com.ucs.edu.Review.dto.ReviewDTO;
import com.ucs.edu.Review.model.Review;

public interface ReviewsService {
	public void saveReview(ReviewDTO dto);
	public List<Review> getReviewList(Long product_id);
}
