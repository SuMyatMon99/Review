package com.ucs.edu.Review.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucs.edu.Review.dto.ShopDTO;
import com.ucs.edu.Review.model.Location;
import com.ucs.edu.Review.model.Shop;
import com.ucs.edu.Review.repository.LocationRepository;
import com.ucs.edu.Review.repository.ShopRepository;

@Service
@Transactional
public class ShopServiceImpl implements ShopService{

	@Autowired
	private ShopRepository shopRepository;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public void saveShop(ShopDTO shopDTO) {
		Location locat=locationRepository.findById(shopDTO.getLocation_id()).get();
		Shop shop = new Shop();
		shop.setShop_name(shopDTO.getShop_name());
		shop.setLocation(locat);
		shopRepository.save(shop);
	}

	@Override
	public List<Location> getLocationList() {
		return locationRepository.findAll();
	}

	@Override
	public List<Shop> getShopList() {
		return shopRepository.findAll();
	}
	
}
