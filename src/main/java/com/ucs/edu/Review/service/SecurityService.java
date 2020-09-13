package com.ucs.edu.Review.service;

public interface SecurityService {
	String findLoggedInUsername();

    void autoLogin(String username, String password);
}
