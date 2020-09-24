package com.ucs.edu.Review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ucs.edu.Review.dto.ProductDTO;
import com.ucs.edu.Review.model.Product;
import com.ucs.edu.Review.service.CategoryService;
import com.ucs.edu.Review.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/create_product")
	public String createProduct(Model model) {
		model.addAttribute("product", new ProductDTO());
		model.addAttribute("category",categoryService.getCategoryList());
		model.addAttribute("shops", productService.getShopList());
		model.addAttribute("brands", productService.getBrandList());
		model.addAttribute("categories", productService.getCategoryList());
		return "create_product";
	}
	@PostMapping("/save_product")
	public String saveProduct(@ModelAttribute ("product") ProductDTO productDTO, Model model,@Param("keyword")String keyword) throws Exception {
		productService.SaveProduct(productDTO);
		model.addAttribute("products", productService.getProductList(keyword));
		model.addAttribute("categories", productService.getCategoryList());
		return "product_list";
	}
	@GetMapping("/product_list")
	public String showProducts( Model model ,@Param("keyword")String keyword) {
		model.addAttribute("products", productService.getProductList(keyword));
		model.addAttribute("categories", productService.getCategoryList());
		return "product_list";
	}
	
	@GetMapping("/product_list/{cat_id}/{keyword}")
	public String showProductList(Model model,@Param("keyword") String keyword) {
		model.addAttribute("categories", productService.getCategoryList());
		List<Product> productList = productService.getProductList(keyword);
		model.addAttribute("products", productList);
		model.addAttribute("keyword",keyword);
		return "product_list";
	}
	@GetMapping("/product_list/{category}")
	public String showProductListByCategory(Model model,@RequestParam("cat_id") Long id) {
		model.addAttribute("categories", productService.getCategoryList());
		List<Product> productList = productService.getProductListByCategory(id);
		model.addAttribute("productss", productList);
		model.addAttribute("cat_id",id);
		return "product_list";
	}
	
	@RequestMapping("/product/{id}")
	public String productDetails(@PathVariable("id") Long id,Model model) {
		System.out.println(id);
		model.addAttribute("product", productService.getProductById(id));
		return "product_detail";
	}
	
	@RequestMapping("/productsbycategory/{cat_id}")
	public String showProductListByCategory(@PathVariable("cat_id") Long id,Model model) {
		System.out.println(id);
		model.addAttribute("categories", productService.getCategoryList());
		model.addAttribute("products", productService.getProductListByCategory(id));
		return "product_list";
	}
	
	/*@GetMapping("/register")
	public String create_register(Model model) {
		return "register";
	}
	@GetMapping("/login")
	public String login_user(Model model) {
		return "login";
	}
	*/
	
	@GetMapping("/blog-details")
	public String showBolgDetails(Model model) {
		return "blog-details";
	}
	
	@GetMapping("/faq")
	public String showFAQ(Model model) {
		return "faq";
	}
}
