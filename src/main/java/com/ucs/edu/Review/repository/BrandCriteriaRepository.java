package com.ucs.edu.Review.repository;

import java.util.List;

import com.ucs.edu.Review.model.Brand;

public interface BrandCriteriaRepository {
	List<Brand> getBrandListByCriteriaSearch(String name);

}
