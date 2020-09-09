package com.ucs.edu.Review.service;

import java.util.List;

import com.ucs.edu.Review.dto.LoginUserDTO;
import com.ucs.edu.Review.model.UserRole;

public interface IUserService {
	
	public void saveUser(LoginUserDTO user);
	public List<UserRole> getUserRoles();

}
