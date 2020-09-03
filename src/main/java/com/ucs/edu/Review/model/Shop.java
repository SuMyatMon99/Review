package com.ucs.edu.Review.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Shop implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long shop_id;
	private String shop_name;
	@OneToOne
	@JoinColumn (name="location_id")
	private Location location;
	public Shop() {
		super();
	}
	public Shop(Long shop_id, String shop_name, Location location) {
		super();
		this.shop_id = shop_id;
		this.shop_name = shop_name;
		this.location = location;
	}
	public Long getShop_id() {
		return shop_id;
	}
	public void setShop_id(Long shop_id) {
		this.shop_id = shop_id;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	@OneToMany(mappedBy = "shop")
	private Set<Product> productList;
	public Shop(Long shop_id, String shop_name, Location location, Set<Product> productList) {
		super();
		this.shop_id = shop_id;
		this.shop_name = shop_name;
		this.location = location;
		this.productList = productList;
	}
	public Set<Product> getProductList() {
		return productList;
	}
	public void setProductList(Set<Product> productList) {
		this.productList = productList;
	}
	
}
