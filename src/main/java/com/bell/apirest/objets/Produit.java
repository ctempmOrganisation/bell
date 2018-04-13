package com.bell.apirest.objets;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cette classe défini un produit 
 * @author Christophe De boeck
 */
@Entity
@Table(name = "Produit")
public class Produit {
	
	// par defaut il va generer automatiquement les valeurs
	@Id
	@GeneratedValue 
	private Long id;
	@Column(name = "titre")
	private String titre;
	@Column(name = "nbPage")
	private int nbPage;
	@Column(name = "auteur")
	private String nomAuteur;
	
	
	// Contructeur 
	public Produit(String titre, int nbPage, String nomAuteur) {
		this.titre = titre;
		this.nbPage = nbPage;
		this.nomAuteur = nomAuteur;
	}
	
	// Contructeur vide
	public Produit() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getNbPage() {
		return nbPage;
	}
	public void setNbPage(int nbPage) {
		this.nbPage = nbPage;
	}
	public String getNomAuteur() {
		return nomAuteur;
	}
	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
	}
}
	
