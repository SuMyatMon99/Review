package com.ucs.edu.Review.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucs.edu.Review.model.LoginUser;
import com.ucs.edu.Review.model.Privileges;
import com.ucs.edu.Review.repository.UserDao;


@Service
@Transactional
public class UserService implements UserDetailsService {
	@Autowired
	UserDao userDao;
	public UserDetails loadUserByUsername(String name)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		LoginUser user=userDao.findUserByUserName(name);
		List<GrantedAuthority> authories=new ArrayList<GrantedAuthority>();
		for(Privileges p : user.getUserRole().getPrivilegesList()){
			GrantedAuthority authority = new SimpleGrantedAuthority(p.getRoleCode());
			authories.add(authority);
		}		
		UserDetails userDetails = (UserDetails) new User();
		return userDetails;
	}

}
