package com.ucs.edu.Review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ucs.edu.Review.model.LoginUser;
import com.ucs.edu.Review.model.UserRole;
@Repository
public interface UserRepository extends JpaRepository<LoginUser, Long> {
	public LoginUser findUserByUserName(String name);
	
	@Query("select s from UserRole s")
	public List<UserRole> getUserRole();
}
