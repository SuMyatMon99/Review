package com.ucs.edu.Review.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

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
	private String photoPath;
	private String descr;
	private Float totalRating;
	private Date date;
	@ManyToOne
	@JoinColumn(name="cat_id")
	private Category category;
	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;
	@ManyToOne
	@JoinColumn(name="shop_id")
	private Shop shop;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=true)
	private LoginUser user;
	
	@OneToMany(mappedBy="product",cascade = CascadeType.ALL)
	private List<Review> getReviewList;
	
	
	public List<Review> getGetReviewList() {
		return getReviewList;
	}

	public void setGetReviewList(List<Review> getReviewList) {
		this.getReviewList = getReviewList;
	}

	@PrePersist
	public void createDate() {
		if(date==null) {
			date = new Date();
		}
	}
	
	public LoginUser getUser() {
		return user;
	}

	public void setUser(LoginUser user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Float getTotalRating() {
		return totalRating;
	}
	public void setTotalRating(Float totalRating) {
		this.totalRating = totalRating;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
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
