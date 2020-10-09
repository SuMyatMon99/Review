package com.ucs.edu.Review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucs.edu.Review.model.Product;
import com.ucs.edu.Review.service.ProductService;

@RestController
public class RestfulController {
	
	@Autowired
	private ProductService service;

	@GetMapping("/productss")
	public ResponseEntity<List<Product>> showProducts(){
		String name= null;
		return ResponseEntity.status(HttpStatus.OK).body(service.getProductList(name));
	}
	
}
