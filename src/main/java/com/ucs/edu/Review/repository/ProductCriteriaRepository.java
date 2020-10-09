package com.ucs.edu.Review.repository;

import java.util.List;

import com.ucs.edu.Review.model.Product;

public interface ProductCriteriaRepository {
	
	List<Product> getProductListByCriteriaSearch(String name);
	
}	
