
package com.ucs.edu.Review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

	@GetMapping("/")
	public String home1() {
		return "index";
	}

	@GetMapping("/home")
	public String home() {
		return "/index";
	}

	@GetMapping("/admin")
	public String admin() {
		return "/admin";
	}

	@GetMapping("/user")
	public String user() {
		return "/user";
	}

	@GetMapping("/about")
	public String about() {
		return "/about";
	}

	@RequestMapping(value = "/403.html")
	public String accessDenied(Model model) {
		return "accessDenied";
	}

}
