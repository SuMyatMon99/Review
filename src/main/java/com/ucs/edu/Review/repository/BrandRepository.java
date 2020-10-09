package com.ucs.edu.Review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ucs.edu.Review.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>,BrandCriteriaRepository{
	
	@Query("SELECT b FROM Brand b WHERE CONCAT(b.brand_name) LIKE %?1%")
	public List<Brand> getBrandListBySearch(String name);
}
