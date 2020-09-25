package com.ucs.edu.Review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ucs.edu.Review.model.LoginUser;
import com.ucs.edu.Review.model.UserRole;
@Repository
public interface UserRepository extends JpaRepository<LoginUser, Long> {
	
	/*
	 * @Query("SELECT l FROM LoginUser WHERE l.username=:1") public LoginUser
	 * findUserByUserName(@Param("name")String name);
	 */
	
	@Query("select s from UserRole s")
	public List<UserRole> getUserRole();
}
