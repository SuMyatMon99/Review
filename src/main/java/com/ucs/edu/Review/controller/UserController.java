
package com.ucs.edu.Review.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ucs.edu.Review.dto.LoginUserDTO;
import com.ucs.edu.Review.dto.UserProfileDTO;
import com.ucs.edu.Review.service.CurrentUserService;
import com.ucs.edu.Review.service.IUserService;

@Controller
public class UserController {

	@Autowired
	IUserService userInfoService;

	@Autowired
	private CurrentUserService currentUserService;
	
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

	@RequestMapping("/login")
	public String login(Model model,String error,String logout){
		 if (error != null)
	            model.addAttribute("error", "Your username and password is invalid.");

	        if (logout != null)
	            model.addAttribute("message", "You have been logged out successfully.");
	        
		return "login";
	}

	/*
	 * @RequestMapping("/admin/login") public String adminlogin(Model model,String
	 * error,String logout){ if (error != null) model.addAttribute("error",
	 * "Your username and password is invalid.");
	 * 
	 * if (logout != null) model.addAttribute("message",
	 * "You have been logged out successfully.");
	 * 
	 * return "/admin/login"; }
	 */
	 @RequestMapping(value="/logout.htm", method=RequestMethod.GET)  
	    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
	        if (auth != null){      
	           new SecurityContextLogoutHandler().logout(request, response, auth);  
	        }  
	         return "redirect:/login.htm";  
	     } 
	 
	 @GetMapping("/profile")
	 public String profile(Model model) {
		 model.addAttribute("user",currentUserService.getCurrentUser());
		 model.addAttribute("profile",new UserProfileDTO());
		 return "profile";
	 }

		/*
		 * @PostMapping("/profile/update") public String saveProfile(Model
		 * model,@ModelAttribute("profile")UserProfileDTO dto) throws Exception {
		 * if(dto.getFile()!=null) { userInfoService.uploadProfile(dto); }
		 * model.addAttribute("user",currentUserService.getCurrentUser()); return
		 * "profile";
		 * 
		 * }
		 */
		
	 
	 	//updated profile with ajax in profile.jsp
		@PostMapping(value="/profile/update")
		public String saveUploadFile(Model model,@RequestParam("file") MultipartFile file,@RequestParam("username")String name) throws Exception {
			model.addAttribute("user",currentUserService.getCurrentUser());
			UserProfileDTO dto = new UserProfileDTO();
			dto.setFile(file);
			dto.setUsername(name);
			if(dto.getFile()!=null) {
				userInfoService.uploadProfile(dto);
				}
			
			return "profile";
		}
		
	 @RequestMapping("/user/user_list")
	 public String showUserList(Model model) {
		 model.addAttribute("userList",userInfoService.getAllUser());
		 return "user_list_view";
	 }
	
}
