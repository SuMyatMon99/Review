package com.ucs.edu.Review.repository;

import java.util.List;

import com.ucs.edu.Review.model.Review;

public interface ReviewCriteriaRepository {
	List<Review> getReviewListBySearchwithCriteria(String name);
}
