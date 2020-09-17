
package com.ucs.edu.Review.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ucs.edu.Review.dto.LoginUserDTO;
import com.ucs.edu.Review.service.UserInfoService;

@Controller
public class UserController {

	@Autowired
	UserInfoService userInfoService;
	
	@RequestMapping(value="/register.htm",method=RequestMethod.GET)
	public String register(Model model){
		model.addAttribute("userDTO", new LoginUserDTO());
		model.addAttribute("roleList",userInfoService.getUserRoles());
		return "register";
	}
	@RequestMapping(value="/register.htm",method=RequestMethod.POST)
	public String postRegister(@ModelAttribute(value="userDTO")LoginUserDTO userDTO ){
		userInfoService.saveUser(userDTO);
		return "redirect:/login.htm";
	}
	@RequestMapping(value="/login.htm")
	public String login(Model model){
		return "login";
	}
	@RequestMapping(value="/403.htm")
	public String accessDenied(Model model){
		return "403";
	}
	 @RequestMapping(value="/logout.htm", method=RequestMethod.GET)  
	    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
	        if (auth != null){      
	           new SecurityContextLogoutHandler().logout(request, response, auth);  
	        }  
	         return "redirect:/login.htm";  
	     } 
}
