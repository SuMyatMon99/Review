package com.ucs.edu.Review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ucs.edu.Review.dto.ProductDTO;
import com.ucs.edu.Review.dto.ReviewDTO;
import com.ucs.edu.Review.model.LoginUser;
import com.ucs.edu.Review.model.Product;
import com.ucs.edu.Review.service.CategoryService;
import com.ucs.edu.Review.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@PreAuthorize("isAuthorized()")
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
		if(productDTO.getProduct_name()!="") {
		productService.SaveProduct(productDTO);
		model.addAttribute("products", productService.getProductList(keyword));
		model.addAttribute("categories", productService.getCategoryList());
		return "redirect:/product_list";
		}else {
			return "redirect:/create_product";
		}
	}
	@GetMapping("/product_list")
	public String showProducts( Model model ,@Param("keyword")String keyword) {
		model.addAttribute("products", productService.getProductList(keyword));
		model.addAttribute("categories", productService.getCategoryList());
		return "product_list";
	}
	
	@RequestMapping("/product_list/{cat_id}")
	public String showProductListByCategory(Model model, @PathVariable("cat_id") Long id) {
		if(id!=null) {
		model.addAttribute("categories", productService.getCategoryList());
		List<Product> productList = productService.getProductListByCategory(id);
		model.addAttribute("products", productList);
		model.addAttribute("cat_id", id);
		return "product_list";
		}else {
			return "redirect:/product_list";
		}
	}
	/*
	 * @RequestMapping("/product_list/{cat_id}/{keyword}") public String
	 * showProductList(Model model, @PathVariable("cat_id") Long
	 * id, @Param("keyword") String keyword) { model.addAttribute("categories",
	 * productService.getCategoryList()); List<Product> productList =
	 * productService.getProductListByKeywordandCategory(id, keyword);
	 * model.addAttribute("products", productList); model.addAttribute("cat_id",id);
	 * model.addAttribute("keyword", keyword); return "product_list"; }
	 */
	
	
	
	@RequestMapping("/productsbycategory/{cat_id}")
	public String showProductListByCategory(@PathVariable("cat_id") Long id, Model model) {
		System.out.println(id);
		model.addAttribute("categories", productService.getCategoryList());
		model.addAttribute("products", productService.getProductListByCategory(id));
		return "product_list";
	}
	
	@ResponseBody 
	@RequestMapping(value = "/search/api/getSearchResult/{id}") 
	public String getSearchResultViaAjax(@PathVariable(value = "id") Integer id) 
	{ 
	 return String.valueOf(id); 
	} 
}
