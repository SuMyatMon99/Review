package com.ucs.edu.Review.dto;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.ucs.edu.Review.model.LoginUser;
import com.ucs.edu.Review.model.UserRole;

public class CurrentUser extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LoginUser user;
	
	public CurrentUser(LoginUser user) {
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRoles().toString()));
		this.user=user;
	}

	public LoginUser getUser() {
		return user;
	}

	public void setUser(LoginUser user) {
		this.user = user;
	}
	
	public Long getId() {
		return user.getId();
	}
	
	public UserRole getRole() {
		return user.getRoles();
	}

	@Override
	public String toString() {
		 return "CurrentUser{" +
	                "user=" + user +
	                "} " + super.toString();
	}

}
