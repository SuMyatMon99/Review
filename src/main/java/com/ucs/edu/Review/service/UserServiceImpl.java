package com.ucs.edu.Review.service;

import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ucs.edu.Review.model.LoginUser;
import com.ucs.edu.Review.model.UserRole;
import com.ucs.edu.Review.repository.UserDao;
import com.ucs.edu.Review.repository.UserRoleRepository;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
    private UserDao userRepository;
    @Autowired
    private UserRoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(LoginUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setUserRole(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public LoginUser findByUsername(String username) {
        return userRepository.findUserByUserName(username);
    }
	@Override
	public List<UserRole> getUserRole() {
		return null;
	}
}
