package com.ucs.edu.Review.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucs.edu.Review.dto.ProductDTO;
import com.ucs.edu.Review.model.Brand;
import com.ucs.edu.Review.model.Category;
import com.ucs.edu.Review.model.LoginUser;
import com.ucs.edu.Review.model.Product;
import com.ucs.edu.Review.model.Shop;
import com.ucs.edu.Review.repository.BrandRepository;
import com.ucs.edu.Review.repository.CategoryRepository;
import com.ucs.edu.Review.repository.ProductRepository;
import com.ucs.edu.Review.repository.ShopRepository;
import com.ucs.edu.Review.repository.UserRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	ServletContext serveletContext;
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private ShopRepository shopRepository;
	public String UPLOAD_DIRECTORY="/images/";
	@Override
	public void SaveProduct(ProductDTO productDTO) throws Exception {
		Float rate = (float) 5.0000;
		if(productDTO!=null) {
		Category cat=categoryRepository.findById(productDTO.getCategory_id()).get();
		Brand brand=brandRepository.findById(productDTO.getBrand_id()).get();
		Shop shop = shopRepository.findById(productDTO.getShop_id()).get();
		Product product = new Product();
		String path =serveletContext.getRealPath(UPLOAD_DIRECTORY);
		String filename = productDTO.getFile().getOriginalFilename();
		product.setProduct_name(productDTO.getProduct_name());
		product.setDescr(productDTO.getDescr());
		product.setTotalRating(rate);
		System.out.println(path+" "+filename);  
		try {
			byte[] bytes = productDTO.getFile().getBytes();
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(
					new File(path+File.separator+filename)));
				out.write(bytes);
				out.flush();
				out.close();
		
			
		}catch(Exception e){
			throw e;
		}
		product.setPhotoPath(filename);
		product.setPrice(productDTO.getPrice());
		product.setBrand(brand);
		product.setCategory(cat);
		product.setShop(shop);
		productRepository.save(product);
		}
	}

	

	@Override
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}


	@Override
	public List<Product> getProductList(String name) {
		if(name!=null) {
		return productRepository.search(name);
		}else {
		return productRepository.findAll();
		}
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



	@Override
	public LoginUser getLoginUser(Long id) {
		return userRepository.findById(id).get();
	}



	@Override
	public List<Product> getProductListByCategory(Long category_id) {
		// TODO Auto-generated method stub
		return productRepository.getProductListByCategory(category_id);
	}




	
}
