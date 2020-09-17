package com.ucs.edu.Review.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucs.edu.Review.dto.BrandDTO;
import com.ucs.edu.Review.model.Brand;
import com.ucs.edu.Review.repository.BrandRepository;

@Service
@Transactional
public class BrandServiceImpl implements BrandService{

	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public void saveBrand(BrandDTO brandDTO) {
		Brand brand = new Brand();
		brand.setBrand_name(brandDTO.getBrand_name());
		brandRepository.save(brand);
	}

	@Override
	public List<Brand> getBrandList() {
		return brandRepository.findAll();
	}

}
