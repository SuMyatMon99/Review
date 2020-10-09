package com.ucs.edu.Review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ucs.edu.Review.dto.ShopDTO;
import com.ucs.edu.Review.service.ShopService;

@Controller
@RequestMapping("/shop")
public class ShopController {
	@Autowired
	private ShopService shopService;
	

	@PreAuthorize("isAuthorized()")
	@GetMapping("/create_shop")
	public String createShop(Model model) {
		model.addAttribute("shop", new ShopDTO());
		return "create_shop";
	}
	@PostMapping("/save_shop")
	public String saveShop(@ModelAttribute ("shop") ShopDTO shopDTO, Model model) {
		if(shopDTO.getShop_name()!="") {
			shopService.saveShop(shopDTO);
			model.addAttribute("shops", shopService.getShopList());
			return "redirect:/shop/shop_list";
			
		}else {
			return "redirect:/shop/create_shop";
		}
		
	}
	@GetMapping("/shop_list")
	public String showShop(Model model) {
		model.addAttribute("shops", shopService.getShopList());
		return "shop_list";
	}
	
	@RequestMapping("/shop_delete/{id}")
	public String deleteShop(Model model,@PathVariable Long id) {
		shopService.deleteShopById(id);
		model.addAttribute("shops", shopService.getShopList());
		return "redirect:/shop/shop_list";
	}
	@RequestMapping("/search")
	public String searchReview(Model model,@Param("search") String search) {
		if(search!="") {
		model.addAttribute("shops",shopService.getShopList(search));
		return "shop_list";
		}else {
			return "redirect:/shop/shop_list";
		}
	}
}
