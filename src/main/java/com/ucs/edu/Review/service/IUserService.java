package com.ucs.edu.Review.service;

import java.util.Collection;

import com.ucs.edu.Review.dto.LoginUserDTO;
import com.ucs.edu.Review.model.LoginUser;

public interface IUserService {
	
	public void saveUser(LoginUserDTO user);

	public LoginUser findByUsername(String name);
	
	Collection<LoginUser> getAllUser();	
	
}
