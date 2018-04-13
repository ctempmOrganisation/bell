package com.bell.apirest.controleur;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bell.apirest.objets.Catalogue;
import com.bell.apirest.objets.Produit;
import com.bell.apirest.objets.ShoppingCart;
import com.bell.apirest.service.ProduitService;
import com.bell.apirest.service.ShoppingCartService;

@RestController
@EnableAutoConfiguration
public class CatalogueControleur {
	
	@Autowired
	private ProduitService produitService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	// Permet de Logger
	private static final Logger logger = LoggerFactory.getLogger(CatalogueControleur.class);

	/**
	 * Methode qui permet de retrouvé un produit via son id dans la bd
	 * @param idProduit
	 * @return
	 */
	@RequestMapping(value = "/produit/{idProduit}", method = RequestMethod.GET)
    public  ResponseEntity<?> getProduit( @PathVariable("idProduit") long idProduit) {
       Produit produit = produitService.read(idProduit);
        
        return new ResponseEntity<Produit>(produit,HttpStatus.OK);
    }
	
	/**
	 * Methode qui permet de retourner le catalogue qui contient la liste de tous les produits
	 * @param idCatalogue
	 * @return
	 */
	@RequestMapping(value = "/catalogue", method = RequestMethod.GET)
    public  ResponseEntity<?> getCatalogue() {
      
		Catalogue catalogue = new Catalogue();
		catalogue.setListePorduit(produitService.readAll());
        
        return new ResponseEntity<Catalogue>(catalogue,HttpStatus.OK);
    }
	
	/**
	 * Methode qui permet d'ajouter un produit au shopping-cart
	 * si la méthode n'est pas accédé via un put, il va simplement retourner un message d'erreur
	 * @throws Exception 
	 */
	@RequestMapping(value = "/shopping-cart/{id}", method = RequestMethod.PUT)
    public  ResponseEntity<?> addToMyCart( @PathVariable("id") long id) throws Exception {
		shoppingCartService.addToMyCart(id);
		// retourne le statut que tout est ok code 200 via postman
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	
	/**
	 * Methode qui permet d'ajouter un produit au shopping-cart
	 * si la méthode n'est pas accédé via un delete, il va simplement retourner un message d'erreur
	 */
	@RequestMapping(value = "/shopping-cart/{id}", method = RequestMethod.DELETE)
    public  ResponseEntity<?> removeFromMyCart( @PathVariable("id") long id) {
		shoppingCartService.removeFromMyCart(id);

		// retourne le statut que tout est ok code 200 via postman
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	/**
	 * Methode qui permet d'afficher tous les element dans mon shopping-cart
	 */
	@RequestMapping(value = "/shopping-cart", method = RequestMethod.GET)
    public  ResponseEntity<?> readMyCart() {
		ShoppingCart myCart = shoppingCartService.readMyCart();
		
		// retourne le statut que tout est ok code 200 via postman
        return new ResponseEntity<ShoppingCart>(myCart, HttpStatus.OK);
    }
	
	
	
	
	
}