package com.ucs.edu.Review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ucs.edu.Review.dto.ShopDTO;
import com.ucs.edu.Review.service.LocationService;
import com.ucs.edu.Review.service.ShopService;

@Controller
public class ShopController {
	@Autowired
	private ShopService shopService;
	@GetMapping("/create_shop")
	public String createShop(Model model) {
		model.addAttribute("shop", new ShopDTO());
		model.addAttribute("locations", shopService.getLocationList());
		return "create_shop";
	}
	@PostMapping("/save_shop")
	public String saveShop(@ModelAttribute ("shop") ShopDTO shopDTO, Model model) {
		shopService.saveShop(shopDTO);
		model.addAttribute("shops", shopService.getShopList());
		return "shop_list";
	}
	@GetMapping("/shop_list")
	public String showShop(Model model) {
		model.addAttribute("shops", shopService.getLocationList());
		return "shop_list";
	}
	
}
