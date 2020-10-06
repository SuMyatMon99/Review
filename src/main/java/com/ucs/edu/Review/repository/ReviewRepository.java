package com.ucs.edu.Review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ucs.edu.Review.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long>{

	@Query("select r from Review r where r.product.product_id=:productId")
	public List<Review> getReviewListByProductId(@Param("productId")Long product_id);
	
}
