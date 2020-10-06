package com.ucs.edu.Review.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucs.edu.Review.dto.LoginUserDTO;
import com.ucs.edu.Review.dto.UserProfileDTO;
import com.ucs.edu.Review.model.LoginUser;
import com.ucs.edu.Review.repository.UserRepository;
import com.ucs.edu.Review.repository.UserRoleRepository;

@Service
@Transactional
public class UserInfoService implements IUserService {
	@Autowired
	ServletContext serveletContext;
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	UserRoleRepository roleRepository;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	public String UPLOAD_DIRECTORY="/images/";
	
	public void saveUser(LoginUserDTO user) {
		LoginUser loginUser = new LoginUser();
		loginUser.setUsername(user.getUserName());
		loginUser.setPassword(passwordEncoder.encode(user.getPassword()));
		loginUser.setRoles(roleRepository.findAll().get(2));
		userRepository.save(loginUser);
	}

	@Override public LoginUser findByUsername(String name) {
	  return userRepository.findUserByUsername(name);
	  }

	@Override
	public List<LoginUser> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public void uploadProfile(UserProfileDTO dto) throws Exception {
		if(dto!=null) {
		LoginUser user = userRepository.findUserByUsername(dto.getUsername());
		String path =serveletContext.getRealPath(UPLOAD_DIRECTORY);
		String filename = dto.getFile().getOriginalFilename();
		System.out.println(path+" "+filename);  
		try {
			byte[] bytes = dto.getFile().getBytes();
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(
					new File(path+File.separator+filename)));
				out.write(bytes);
				out.flush();
				out.close();
			
		}catch(Exception e){
			throw e;
		}
		user.setPhotoPath(filename);
		if(user!=null) {
			userRepository.save(user);
		}
	}
	}

}
