package com.ucs.edu.Review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ucs.edu.Review.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query("SELECT p FROM Product p WHERE CONCAT(p.product_name, p.descr, p.price) LIKE %?1% and p.category.cat_id=2")
	public List<Product> search(String keyword);
	
	@Query("SELECT p FROM Product p LEFT JOIN Category c on p.category.cat_id=c.cat_id WHERE p.category.cat_id=:catId")
	public List<Product> getProductListByCategory(@Param("catId")Long id);
	
	@Modifying
	@Query("UPDATE Product p SET p.totalRating=p.totalRating+:rating WHERE p.product_id=:productId")
	public void updateProduct(@Param("rating") Float rating,@Param("productId")Long id);
}
