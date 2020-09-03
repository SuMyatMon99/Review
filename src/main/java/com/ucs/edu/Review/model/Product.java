package com.ucs.edu.Review.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long product_id;
	private String product_name;
	private Double price;
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;
	@ManyToOne
	@JoinColumn(name="shop_id")
	private Shop shop;
	public Product(Long product_id, String product_name, Double price, Category category, Brand brand, Shop shop) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
		this.category = category;
		this.brand = brand;
		this.shop = shop;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public Product() {
		super();
	}
	public Product(Long product_id, String product_name, Category category, Brand brand) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.category = category;
		this.brand = brand;
	}
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

}
