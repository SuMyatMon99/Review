package com.ucs.edu.Review.service;

import java.util.List;

import com.ucs.edu.Review.dto.ShopDTO;
import com.ucs.edu.Review.model.Shop;

public interface ShopService {
	public void saveShop(ShopDTO shopDTO);
	public List<Shop> getShopList();
}
