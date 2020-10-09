package com.ucs.edu.Review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ucs.edu.Review.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>{
	
	@Query("SELECT s FROM Shop s WHERE CONCAT(s.shop_name,s.address,s.lat,s.lng,s.type) LIKE %?1%")
	public List<Shop> getShopListBySearch(String name);
}
