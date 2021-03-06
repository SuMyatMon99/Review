package com.ucs.edu.Review.service;

import java.util.List;

import com.ucs.edu.Review.dto.BrandDTO;
import com.ucs.edu.Review.model.Brand;

public interface BrandService {
	public void saveBrand(BrandDTO brandDTO);
	public List<BrandDTO> getBrandList();
	public void deleteBand(Long id);
	public List<BrandDTO> getBrandListBySearch(String name);
}
