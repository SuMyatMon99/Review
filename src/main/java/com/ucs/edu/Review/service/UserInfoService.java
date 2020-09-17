package com.ucs.edu.Review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucs.edu.Review.dto.LoginUserDTO;
import com.ucs.edu.Review.model.LoginUser;
import com.ucs.edu.Review.model.UserRole;
import com.ucs.edu.Review.repository.UserRepository;

@Service
@Transactional
public class UserInfoService implements IUserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	public void saveUser(LoginUserDTO user) {
		// TODO Auto-generated method stub
		LoginUser loginUser=new LoginUser();
		loginUser.setUserName(user.getUserName());
		loginUser.setPassword(passwordEncoder.encode(user.getPassword()));
		loginUser.getUserRole().setId(user.getRoleId());
		userRepository.save(loginUser);
	}
	public List<UserRole> getUserRoles() {
		// TODO Auto-generated method stub
		return userRepository.getUserRole();
	}

}
