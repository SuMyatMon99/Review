package com.ucs.edu.Review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.ucs.edu.Review.model.Location;
import com.ucs.edu.Review.repository.LocationRepository;

@Controller
public class LocationController {
	@Autowired
	private LocationRepository locationRepository;
	 
	@GetMapping("/create_location")
	public String createLocation(Model model) {
		model.addAttribute("location", new Location());
		return "create_location";
	}
	@PostMapping("/save_location")
	public String saveLocation(@ModelAttribute ("location") Location location, Model model) {
		locationRepository.save(location);
		model.addAttribute("locations", locationRepository.findAll());
		return "location_list";
	}
}
