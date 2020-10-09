
package com.ucs.edu.Review.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ucs.edu.Review.service.CategoryService;

@Controller
public class DefaultController {

	@Autowired 
	private CategoryService categoryService;
	
	@GetMapping("/")
	public String home1(Model model) {
		model.addAttribute("categories",categoryService.getCategoryList());
		return "index";
	}
	@GetMapping("/admin")
	public String adminHome(Model model) {
		return "index";
	}
	
	@GetMapping("/admin/adminProfile")
	public String adminProfile(Model model) {
		return "admin_profile";
	}
	@GetMapping("/admin/adminContact")
	public String adminContact(Model model) {
		return "admin_contact";
	}

	@GetMapping("/blog-details.htm")
	public String home() {
		return "blog-details";
	}

	@GetMapping("/blog.htm")
	public String admin() {
		return "blog";
	}
	
	@GetMapping("/chartJs")
	public String showChart() {
		return "chartJsPage";
	}

	@GetMapping("/faq.htm")
	public String user() {
		return "faq";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}

	@RequestMapping(value = "/403.html")
	public String accessDenied(Model model) {
		return "accessDenied";
	}
	@RequestMapping("/default")
	public String defaultAfterLogin(HttpServletRequest request) {
		Collection<? extends GrantedAuthority> authorities;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        authorities = auth.getAuthorities();
        String myRole = authorities.toArray()[0].toString();
        String admin = "ADMIN";
	        if (myRole.equals(admin)) {
	            return "redirect:/admin/product_list";
	        }
	        return "redirect:/";
	    }
	}

