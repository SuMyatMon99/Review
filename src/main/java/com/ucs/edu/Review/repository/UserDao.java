package com.ucs.edu.Review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucs.edu.Review.model.LoginUser;
@Repository
public interface UserDao extends JpaRepository<LoginUser, Long> {
	public LoginUser findUserByUserName(String name);
}
