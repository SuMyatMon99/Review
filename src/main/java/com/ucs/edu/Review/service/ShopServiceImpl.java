package com.ucs.edu.Review.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucs.edu.Review.dto.ShopDTO;
import com.ucs.edu.Review.model.Shop;
import com.ucs.edu.Review.repository.ShopRepository;

@Service
@Transactional
public class ShopServiceImpl implements ShopService{

	@Autowired
	private ShopRepository shopRepository;
	
	@Override
	public void saveShop(ShopDTO shopDTO) {
		Shop shop = new Shop();
		shop.setShop_name(shopDTO.getShop_name());
		shop.setAddress(shopDTO.getAddress());
		shop.setLat(shopDTO.getLat());
		shop.setLng(shopDTO.getLng());
		shop.setType(shopDTO.getType());
		shopRepository.save(shop);
	}

	@Override
	public List<Shop> getShopList() {
		return shopRepository.findAll();
	}
	
}
