package com.ucs.edu.Review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ucs.edu.Review.model.Shop;
import com.ucs.edu.Review.repository.LocationRepository;
import com.ucs.edu.Review.repository.ShopRepository;

@Controller
public class ShopController {
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private ShopRepository shopRepository;
	@GetMapping("/create_shop")
	public String createShop(Model model) {
		model.addAttribute("shop", new Shop());
		model.addAttribute("locations", locationRepository.findAll());
		return "create_shop";
	}
	@PostMapping("/save_shop")
	public String saveShop(@ModelAttribute ("shop") Shop shop, Model model) {
		shopRepository.save(shop);
		model.addAttribute("shops", shopRepository.findAll());
		return "shop_list";
	}
}
