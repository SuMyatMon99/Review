package com.ucs.edu.Review.converter;

import com.ucs.edu.Review.dto.ShopDTO;
import com.ucs.edu.Review.model.Shop;

public class ShopConverter {
	
	public static Shop toEntity(ShopDTO dto) {
		Shop shop  = new Shop();
		if(dto.getShop_id()!=null) {
			shop.setShop_id(dto.getShop_id());
		}
		shop.setShop_name(dto.getShop_name());
		shop.setAddress(dto.getAddress());
		shop.setLat(dto.getLat());
		shop.setLng(dto.getLng());
		shop.setType(dto.getType());
		return shop;
	}
	
	public static ShopDTO toDTO(Shop shop) {
		ShopDTO dto = new ShopDTO();
		
		if(shop.getShop_id()!=null) {
			dto.setShop_id(shop.getShop_id());
		}
		dto.setShop_name(shop.getShop_name());
		dto.setAddress(shop.getAddress());
		dto.setLat(shop.getLat());
		dto.setLng(shop.getLng());
		dto.setType(shop.getType());
		return dto;
		
		
	}
}
