package com.ucs.edu.Review.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucs.edu.Review.converter.BrandConverter;
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
		if(brandDTO.getBrand_name()!=null) {
		Brand brand = new Brand();
		brand.setBrand_name(brandDTO.getBrand_name());
		brandRepository.save(brand);
		}
	}

	@Override
	public List<BrandDTO> getBrandList() {
		List<BrandDTO> dto = brandRepository.findAll().stream().map(BrandConverter::toDTO).collect(Collectors.toList());
		return dto;
	}

	@Override
	public void deleteBand(Long id) {
		brandRepository.deleteById(id);
	}
	
	
}
