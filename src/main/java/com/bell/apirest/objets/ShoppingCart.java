package com.bell.apirest.objets;

import java.util.List;

/**
 * Cette classe défini mon shopping cart
 * Je veux pouvoir ajouter ou supprimer un produit
 * On pourrait aussi le store dans la BD mais dans cette exercice je vais me contenter de 
 * le mettre dans une liste de produit qui represente mon shopping-cart 
 * 
 * @author Christophe De boeck
 */

public class ShoppingCart {

	private List<Produit> myShoppingCart;
	

	public List<Produit> getMyShoppingCart() {
		return myShoppingCart;
	}

	public void setMyShoppingCart(List<Produit> myShoppingCart) {
		this.myShoppingCart = myShoppingCart;
	}
}
