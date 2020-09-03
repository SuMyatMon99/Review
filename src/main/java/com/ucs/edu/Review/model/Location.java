package com.ucs.edu.Review.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Location implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long location_id;
	public Long getLocation_id() {
		return location_id;
	}
	public Location() {
		super();
	}
	public Location(Long location_id, Shop shop) {
		super();
		this.location_id = location_id;
		this.shop = shop;
	}
	public void setLocation_id(Long location_id) {
		this.location_id = location_id;
	}
	@OneToOne(mappedBy = "location")
	private Shop shop;
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
}
