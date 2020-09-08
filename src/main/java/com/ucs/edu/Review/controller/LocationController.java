package com.ucs.edu.Review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
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
	
	@GetMapping("/located/{name}")
	public @ResponseBody Location getStudentListByName(@PathVariable(value="name")String name,Model model){
		return locationRepository.findByNameLike(name);
	}
	@GetMapping(value = "/get",produces = { MimeTypeUtils.APPLICATION_JSON_VALUE },
			headers = "Accept=application/json")
	public ModelAndView employeelist() {
	    Gson gson = new Gson();
	    String json = gson.toJson(locationRepository.findAll() );

	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject(json);

	    return modelAndView;
	}
	
	}
