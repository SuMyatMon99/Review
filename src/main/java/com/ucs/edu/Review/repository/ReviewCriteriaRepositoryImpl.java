package com.ucs.edu.Review.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.ucs.edu.Review.model.Review;

public class ReviewCriteriaRepositoryImpl implements ReviewCriteriaRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Review> getReviewListBySearchwithCriteria(String name) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Review> cq = cb.createQuery(Review.class);
		Root<Review> review = cq.from(Review.class);
		Predicate p1 =cb.like(review.get("comment"),"%"+name+"%");
		Predicate p2 =cb.like(review.get("user.username"),"%"+name+"%");
		Predicate p3 =cb.like(review.get("product.product_name"),"%"+name+"%");
		cq.where(p1,p2,p3);
		TypedQuery<Review> results= em.createQuery(cq);
		return results.getResultList();
	}

}
