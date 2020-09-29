package com.ucs.edu.Review.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucs.edu.Review.converter.ShopConverter;
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
		Shop shop = ShopConverter.toEntity(shopDTO);
		shopRepository.save(shop);
	}

	@Override
	public List<ShopDTO> getShopList() {
		List<ShopDTO> shopDTOList= shopRepository.findAll().stream().map(ShopConverter::toDTO).collect(Collectors.toList());
		return shopDTOList;
	}
	
}
