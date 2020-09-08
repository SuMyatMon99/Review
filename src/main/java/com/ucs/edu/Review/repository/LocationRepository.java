package com.ucs.edu.Review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ucs.edu.Review.model.Location;
@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{
	
	@Query("select s from Location s where s.name=?1")
	public Location findByNameLike(String name);
	
}
