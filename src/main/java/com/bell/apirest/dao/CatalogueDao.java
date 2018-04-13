package com.bell.apirest.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bell.apirest.objets.Catalogue;

@Repository
public class CatalogueDao {
	@PersistenceContext
	private EntityManager entityManager;


	public void create(Catalogue apiRequest) {
		entityManager.persist(apiRequest);
	}


	public void update(Catalogue apiRequest) {
		entityManager.merge(apiRequest);
	}


	public Catalogue getCatalogueById(long id) {
		return entityManager.find(Catalogue.class, id);
	}


	public void delete(long id) {
		Catalogue catalogue = getCatalogueById(id);
		if (catalogue != null) {
			entityManager.remove(catalogue);
		}
	}
}