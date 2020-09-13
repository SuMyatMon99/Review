package com.ucs.edu.Review.service;

import java.util.List;

import com.ucs.edu.Review.model.LoginUser;
import com.ucs.edu.Review.model.UserRole;

public interface UserService {
    public void save(LoginUser user);
    
    public List<UserRole> getUserRole();
    LoginUser findByUsername(String username);
}
