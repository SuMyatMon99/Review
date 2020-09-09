package com.ucs.edu.Review.service;

import java.util.List;

import com.trustcore.security.dto.LoginUserDTO;
import com.trustcore.security.model.UserRole;

public interface IUserService {
	
	public void saveUser(LoginUserDTO user);
	public List<UserRole> getUserRoles();

}
