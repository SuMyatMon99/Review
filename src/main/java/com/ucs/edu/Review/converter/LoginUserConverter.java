package com.ucs.edu.Review.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ucs.edu.Review.dto.LoginUserDTO;
import com.ucs.edu.Review.model.LoginUser;
import com.ucs.edu.Review.repository.UserRoleRepository;

public class LoginUserConverter {
	
	@Autowired
	public static UserRoleRepository roleRepository;
	
	@Autowired
	static BCryptPasswordEncoder passwordEncoder;
	
	public static LoginUser toEntity(LoginUserDTO dto) {
		LoginUser user = new LoginUser();
		if(dto.getId()!= null && dto.getPassword() != null) {
			user.setId(dto.getId());
		}
		user.setUsername(dto.getUserName());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		System.out.println(passwordEncoder.encode(dto.getPassword()));
		user.setRoles(roleRepository.findAll().get(2));
		return user;
	}
	
	public static LoginUserDTO toDTO(LoginUser user) {
		LoginUserDTO dto = new LoginUserDTO();
		if(user.getId()!=null) {
			dto.setId(user.getId());
		}
		dto.setUserName(user.getUsername());
		dto.setPassword(user.getPassword());
		dto.setRoleId(user.getRoles().getId());
		return dto;
	}
	
}
