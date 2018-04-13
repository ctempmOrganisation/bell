package com.bell.apirest.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bell.apirest.dao.ProduitDao;
import com.bell.apirest.objets.Produit;
import com.bell.apirest.objets.ShoppingCart;

/**
 * Cette classe inclu la logique d'affaire pour l'ajout / suppression / lecture de mon panier
 * 
 * @author Christophe De boeck
 */
@Service
@Transactional
public class ShoppingCartService {
	
	private static ShoppingCart myCart = new ShoppingCart();
	
	@Autowired 
	ProduitDao produitDao;
	
	public void addToMyCart(long id) throws Exception{
		
		Produit produit = null;
		// si une erreur lors de la lecture, on throw un exception
		try{
			produit = produitDao.getProduitById(id);	
		}catch(Exception e){
			throw new Exception ("Erreur lors de la lecture d'un produit pour l'ajout au panier");			
		}
		
		// s'il n'y a encore aucun liste dans mon panier, je l'a rajoute avant d'ajouter mon produit
		if(null == myCart.getMyShoppingCart() || myCart.getMyShoppingCart().isEmpty()){
			myCart.setMyShoppingCart(new ArrayList<>());
		}
		
		// puis je rajoute le produit
		myCart.getMyShoppingCart().add(produit);
	}
	
	public void removeFromMyCart(long id) {
		
		// si mon panier est non null et non vide
		if(null !=myCart.getMyShoppingCart() && !myCart.getMyShoppingCart().isEmpty()){
			// on parcourt le panier
			for(Produit produit : myCart.getMyShoppingCart() ){
				if(produit.getId() == id){
					myCart.getMyShoppingCart().remove(produit);
					// Je supprime le premier element trouvé et je sortir de la boucle
					break;
				}
			}// fin du for
		}
	}
	
	/**
	 * methode qui permet la lecture complete du cart
	 * @return
	 */
	public ShoppingCart readMyCart(){
		return myCart;
	}		
}

