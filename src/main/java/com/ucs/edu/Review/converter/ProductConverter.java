package com.ucs.edu.Review.converter;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.ServletContext;
import com.ucs.edu.Review.dto.ProductDTO;
import com.ucs.edu.Review.model.Brand;
import com.ucs.edu.Review.model.Category;
import com.ucs.edu.Review.model.Product;
import com.ucs.edu.Review.model.Shop;
import com.ucs.edu.Review.repository.BrandRepository;
import com.ucs.edu.Review.repository.CategoryRepository;
import com.ucs.edu.Review.repository.ShopRepository;
import com.ucs.edu.Review.repository.UserRepository;
import com.ucs.edu.Review.service.CurrentUserServiceInterface;

public class ProductConverter {
	
	@Autowired
	private static CategoryRepository categoryRepository;
	
	@Autowired
	private static BrandRepository brandRepository;
	
	@Autowired
	private static ShopRepository shopRepository;
	
	@Autowired
	private static CurrentUserServiceInterface currentUser;
	
	public void getRealPath() {
	}

	public static Product toEntity(ProductDTO dto) throws Exception {
		//String UPLOAD_DIRECTORY="/images/";
		Product product = new Product();
		Float rate = (float) 5.0000;
		if(dto!=null) {
		Category cat=categoryRepository.findById(dto.getCategory_id()).get();
		Brand brand=brandRepository.findById(dto.getBrand_id()).get();
		Shop shop = shopRepository.findById(dto.getShop_id()).get();
		//String path =ServletContext.getRealPath(UPLOAD_DIRECTORY);
		String filename = dto.getFile().getOriginalFilename();
		product.setProduct_name(dto.getProduct_name());
		product.setDescr(dto.getDescr());
		product.setTotalRating(rate);
		/*
		 * //System.out.println(path+" "+filename); try { byte[] bytes =
		 * dto.getFile().getBytes(); BufferedOutputStream out = new
		 * BufferedOutputStream(new FileOutputStream( // new
		 * File(path+File.separator+filename))); out.write(bytes); out.flush();
		 * out.close();
		 * 
		 * }catch(Exception e){ throw e; }
		 */
		product.setPhotoPath(filename);
		product.setPrice(dto.getPrice());
		product.setBrand(brand);
		product.setCategory(cat);
		product.setShop(shop);
		product.setUser(currentUser.getCurrentUser());
		}
		
		return product;
	}
	
	public static ProductDTO toDTO(Product product) {
		ProductDTO dto = new ProductDTO();
		
		return dto;
	}
}
