package com.ucs.edu.Review.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

@Entity
public class Review implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long reviewId;
	private String comment;
	private Date createdDate;
	private Double rating;
	
	@ManyToOne
	@JoinColumn(name="productId",nullable=false)
	private Product product;
	
	@OneToOne
	@JoinColumn(name="userId",nullable=false)
	private LoginUser user;	

	public Review() {
		super();
	}

	public Review(Long reviewId, String comment, Date createdDate, Double rating, Product product, LoginUser user) {
		super();
		this.reviewId = reviewId;
		this.comment = comment;
		this.createdDate = createdDate;
		this.rating = rating;
		this.product = product;
		this.user = user;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public LoginUser getUser() {
		return user;
	}

	public void setUser(LoginUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", comment=" + comment + ", createdDate=" + createdDate + ", product="
				+ product + ", user=" + user + "]";
	}
	
	@PrePersist
	public void OnCreate() {
		createdDate = new Date();
	}
	
}
