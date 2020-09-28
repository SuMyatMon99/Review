
package com.ucs.edu.Review.controller;

import java.security.Principal;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.ucs.edu.Review.dto.LoginUserDTO;
import com.ucs.edu.Review.service.IUserService;

@Controller
public class UserController {

	@Autowired
	IUserService userInfoService;

	/*@Autowired
	SecurityService securityService;
	*/
	@RequestMapping(value="/register.htm",method=RequestMethod.GET)
	public String register(Model model){
		model.addAttribute("userDTO", new LoginUserDTO());
		return "register";
	}

	@RequestMapping(value = "/register.htm", method = RequestMethod.POST)
	public String postRegister(@ModelAttribute(value = "userDTO") LoginUserDTO userDTO) {
		userInfoService.saveUser(userDTO);
		//securityService.autoLogin(userDTO.getUserName(), userDTO.getUserName());
		return "redirect:/login.htm";
	}

	@RequestMapping(value="/login")
	public String login(Model model,String error,String logout){
		 if (error != null)
	            model.addAttribute("error", "Your username and password is invalid.");

	        if (logout != null)
	            model.addAttribute("message", "You have been logged out successfully.");
	        
		return "login";
	}
	 @RequestMapping(value="/logout.htm", method=RequestMethod.GET)  
	    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
	        if (auth != null){      
	           new SecurityContextLogoutHandler().logout(request, response, auth);  
	        }  
	         return "redirect:/login.htm";  
	     } 
	 
	 @RequestMapping("/profile")
	 public String profile(Principal principal,Model model) {
		 model.addAttribute("username",principal.getName());
		 return "profile";
	 }
	 
	@RequestMapping(value="/username",method = RequestMethod.GET)
	@ResponseBody
	public String currenntUserName(Principal principal) {
		
		return principal.getName();
	}
}
