package com.ucs.edu.Review.converter;

import com.ucs.edu.Review.dto.BrandDTO;
import com.ucs.edu.Review.model.Brand;

public class BrandConverter {
	
	public static Brand toEntity(BrandDTO dto) {
		Brand brand = new Brand();
		if(dto.getBrand_id()!=null) {
			brand.setBrand_id(dto.getBrand_id());
		}
		brand.setBrand_name(dto.getBrand_name());
		return brand;
	}
	
	public static BrandDTO toDTO(Brand brand) {
		BrandDTO dto= new BrandDTO();
		if(brand.getBrand_id()!=null) {
			dto.setBrand_id(brand.getBrand_id());
		}
		dto.setBrand_name(brand.getBrand_name());
		return dto;
	}
}
