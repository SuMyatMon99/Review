package com.ucs.edu.Review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ucs.edu.Review.dto.LocationDTO;
import com.ucs.edu.Review.model.Location;
import com.ucs.edu.Review.service.LocationService;

@Controller
public class LocationController {

	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/create_location")
	public String createLocation(Model model) {
		model.addAttribute("location", new LocationDTO());
		return "create_location";
	}
	@PostMapping("/save_location")
	public String saveLocation(@ModelAttribute("location") LocationDTO locationDTO, Model model) {
		locationService.saveLocation(locationDTO);
		model.addAttribute("locations", locationService.getLocationList());
		return "location_list";
	}
	@GetMapping("/location_list")
	public String showLocations(Model model) {
		model.addAttribute("locations", locationService.getLocationList());
		return "location_list";
	}
	}
