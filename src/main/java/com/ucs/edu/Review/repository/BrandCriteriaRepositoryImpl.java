package com.ucs.edu.Review.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.ucs.edu.Review.model.Brand;

public class BrandCriteriaRepositoryImpl implements BrandCriteriaRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Brand> getBrandListByCriteriaSearch(String name) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Brand> cq = cb.createQuery(Brand.class);
		Root<Brand> brand = cq.from(Brand.class);
		Predicate namePre = cb.like(brand.get("brand_name"),"%"+name+"%");
		cq.where(namePre);
		TypedQuery<Brand> list = em.createQuery(cq);
		return list.getResultList();
	}
}
