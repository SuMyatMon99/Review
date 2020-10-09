package com.ucs.edu.Review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ucs.edu.Review.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	@Query("SELECT p FROM Category p WHERE CONCAT(p.cat_name) LIKE %?1%")
	public List<Category> getCategoryListBySearch(String name);
}
