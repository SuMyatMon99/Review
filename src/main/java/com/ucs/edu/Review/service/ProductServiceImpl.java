package com.ucs.edu.Review.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucs.edu.Review.dto.ProductDTO;
import com.ucs.edu.Review.model.Brand;
import com.ucs.edu.Review.model.Category;
import com.ucs.edu.Review.model.Location;
import com.ucs.edu.Review.model.Product;
import com.ucs.edu.Review.model.Shop;
import com.ucs.edu.Review.repository.BrandRepository;
import com.ucs.edu.Review.repository.CategoryRepository;
import com.ucs.edu.Review.repository.ProductRepository;
import com.ucs.edu.Review.repository.ShopRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private ShopRepository shopRepository;
	
	@Override
	public void SaveProduct(ProductDTO productDTO) {
		Category cat=categoryRepository.findById(productDTO.getCategory_id()).get();
		Brand brand=brandRepository.findById(productDTO.getBrand_id()).get();
		Shop shop = shopRepository.findById(productDTO.getShop_id()).get();
		Product product = new Product();
		product.setProduct_name(productDTO.getProduct_name());
		product.setPrice(productDTO.getPrice());
		product.setBrand(brand);
		product.setCategory(cat);
		product.setShop(shop);
		productRepository.save(product);
	}

	

	@Override
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}


	@Override
	public List<Product> getProductList() {
		return productRepository.findAll();
	}



	@Override
	public List<Brand> getBrandList() {
		// TODO Auto-generated method stub
		return brandRepository.findAll();
	}



	@Override
	public List<Shop> getShopList() {
		// TODO Auto-generated method stub
		return shopRepository.findAll();
	}



	
}
