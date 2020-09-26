package com.ucs.edu.Review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ucs.edu.Review.model.LoginUser;
@Repository
public interface UserRepository extends JpaRepository<LoginUser, Long> {
	
	public LoginUser findUserByUsername(String username);

}
