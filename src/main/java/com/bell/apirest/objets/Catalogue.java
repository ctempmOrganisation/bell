package com.bell.apirest.objets;

import java.util.List;

/**
 * Cette classe défini un catalogue qui est en fait simplement une liste de produit
 * @author Christophe De boeck
 */
public class Catalogue {
	
	private List<Produit> listePorduit;

	public List<Produit> getListePorduit() {
		return listePorduit;
	}

	public void setListePorduit(List<Produit> listePorduit) {
		this.listePorduit = listePorduit;
	}
	
	
	
}
	
