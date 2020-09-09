package com.ucs.edu.Review.repository;

import java.util.List;

import com.ucs.edu.Review.model.LoginUser;
import com.ucs.edu.Review.model.UserRole;

public interface IUserDao {
	public LoginUser findUserByUserName(String name);
	public void saveUser(LoginUser user);
	public List<UserRole> getUserRoles();
}
