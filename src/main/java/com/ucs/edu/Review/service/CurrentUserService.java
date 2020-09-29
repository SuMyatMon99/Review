package com.ucs.edu.Review.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ucs.edu.Review.model.LoginUser;
import com.ucs.edu.Review.repository.UserRepository;

@Service
public class CurrentUserService implements CurrentUserServiceInterface{
	
	@Autowired 
	private UserRepository userRepository;
	
	@Override
	public LoginUser getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	if (principal instanceof UserDetails) {
		  String username = ((UserDetails)principal).getUsername();
			System.out.println("String"+username);	
			return userRepository.findUserByUsername(username);
		} else {
		  String username = principal.toString();
			System.out.println("TO String:"+username);
			return null;
		}
	}
	}
	

