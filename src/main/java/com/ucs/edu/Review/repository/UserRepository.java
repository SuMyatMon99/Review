package com.ucs.edu.Review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ucs.edu.Review.model.LoginUser;
@Repository
public interface UserRepository extends JpaRepository<LoginUser, Long> {
	
	public LoginUser findUserByUsername(String name);
	
	public LoginUser findByEmail(String email);
	
    @Query("SELECT u FROM LoginUser u join u.roles r WHERE u.email = :email and r.name='ADMIN'")
	public LoginUser findAdmin(String email);
	
    @Query("SELECT u FROM LoginUser u join u.roles r WHERE u.email = :email and r.name='USER'")
	public LoginUser findUser(String email);

}
