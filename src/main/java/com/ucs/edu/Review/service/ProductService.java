package com.ucs.edu.Review.service;

import java.util.List;

import com.ucs.edu.Review.dto.ProductDTO;
import com.ucs.edu.Review.model.Brand;
import com.ucs.edu.Review.model.Category;
import com.ucs.edu.Review.model.LoginUser;
import com.ucs.edu.Review.model.Product;
import com.ucs.edu.Review.model.Shop;

public interface ProductService {
	public void SaveProduct(ProductDTO productDTO) throws Exception;
	public List<Product> getProductList(String name);
	public List<Brand> getBrandList();
	public List<Category> getCategoryList();
	public List<Shop> getShopList();
	public LoginUser getLoginUser(Long id);
	
	public List<Product> getProductListByCategory(Long category_id);

}
