package com.ucs.edu.Review.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.ucs.edu.Review.model.Product;

public class ProductCriteriaRepositoryImpl implements ProductCriteriaRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Product> getProductListByCriteriaSearch(String name) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> product  = cq.from(Product.class);
		Expression<String> path = product.get("product_name");
//		  Expression<String> param = cb.parameter(String.class);
		Predicate s2 = cb.like(path,"%"+name+"%" );
		cq.where(s2);
		TypedQuery<Product> query = em.createQuery(cq); 
		return query.getResultList();
	}
	
}
