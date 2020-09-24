package com.ucs.edu.Review.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucs.edu.Review.dto.LoginUserDTO;
import com.ucs.edu.Review.model.LoginUser;
import com.ucs.edu.Review.repository.UserRepository;
import com.ucs.edu.Review.repository.UserRoleRepository;

@Service
@Transactional
public class UserInfoService /* implements IUserService */ {
	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	UserRoleRepository roleRepository;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	public void saveUser(LoginUserDTO user) {
		// TODO Auto-generated method stub
		LoginUser loginUser=new LoginUser();
		loginUser.setUsername(user.getUserName());
		loginUser.setPassword(passwordEncoder.encode(user.getPassword()));
        loginUser.setRoles(new HashSet<>(roleRepository.findAll()));
		userRepository.save(loginUser);
	}
	
	/*
	 * @Override public LoginUser findByUsername(String name) { // TODO
	 * Auto-generated method stub //return userRepository.findUserByUserName(name);
	 * }
	 */

}
