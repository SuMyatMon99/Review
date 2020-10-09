package com.ucs.edu.Review.dto;

public class ReviewDTO {
	private Long id;
	private String comment;
	private Float rating;
	private Long product_id;
	
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Float getRating() {
		return rating;
	}
	public void setRating(Float rating2) {
		this.rating = rating2;
	}
	
}
