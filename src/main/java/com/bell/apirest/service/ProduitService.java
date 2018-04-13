package com.bell.apirest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bell.apirest.dao.ProduitDao;
import com.bell.apirest.objets.Produit;

/**
 * Cette classe inclu la logique d'affaire avant d'appeler le dao
 * 
 * @author Christophe De boeck
 */
@Service
@Transactional
public class ProduitService {


	@Autowired
	private ProduitDao produitDao;

	public void create(Produit produit) {
		produitDao.create(produit);
	}
	
	public Produit read(long id) {
		return produitDao.getProduitById(id);
	}
	
	public List<Produit> readAll(){
		return produitDao.readAll();
	}
}

