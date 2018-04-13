package com.bell.apirest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bell.apirest.objets.Produit;

/**
 * Cette classe permet l'insertion d'un produit en bd
 * @author Christophe De boeck
 */
@Repository
public class ProduitDao {
	@PersistenceContext
	private EntityManager entityManager;


	public void create(Produit produitRequete) {
		entityManager.persist(produitRequete);
	}


	public void update(Produit produitRequete) {
		entityManager.merge(produitRequete);
	}


	public Produit getProduitById(long id) {
		return entityManager.find(Produit.class, id);
	}
	
	/**
	 * Permet de retourner la liste de tous les produits contenu dans la bd
	 * @return
	 */
	public List<Produit> readAll() {
		return entityManager.createQuery("FROM Produit", Produit.class).getResultList();
	}


	public void delete(long id) {
		Produit produit = getProduitById(id);
		if (produit != null) {
			entityManager.remove(produit);
		}
	}
}