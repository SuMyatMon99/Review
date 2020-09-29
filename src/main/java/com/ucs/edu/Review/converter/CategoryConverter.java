package com.ucs.edu.Review.converter;

import com.ucs.edu.Review.dto.CategoryDTO;
import com.ucs.edu.Review.model.Category;

public class CategoryConverter {
	
	public static Category toEntity(CategoryDTO dto) {
		Category cat = new Category();
		if(dto.getCat_id()!=null) {
			cat.setCat_id(dto.getCat_id());
		}
		cat.setCat_name(dto.getCat_name());
		return cat;
	}
	
	public static CategoryDTO toDTO(Category cat) {
		CategoryDTO dto = new CategoryDTO();
		if(cat.getCat_id()!=null) {
			dto.setCat_id(cat.getCat_id());
		}
		dto.setCat_name(cat.getCat_name());
		return dto;
	}
	
}
