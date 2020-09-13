package com.ucs.edu.Review.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucs.edu.Review.model.LoginUser;
import com.ucs.edu.Review.model.UserRole;
import com.ucs.edu.Review.repository.UserDao;


@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	UserDao userDao;
	
	public UserDetails loadUserByUsername(String name)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		LoginUser user=userDao.findUserByUserName(name);
		List<GrantedAuthority> authories=new ArrayList<GrantedAuthority>();
		for(UserRole p : user.getUserRole()){
			GrantedAuthority authority = new SimpleGrantedAuthority(p.getRoleName());
			authories.add(authority);
		}		
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authories);
	}

}
