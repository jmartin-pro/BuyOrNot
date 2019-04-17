package com.ppe.buyornot.bdd.model;

import java.util.List;

public class Magasin {

	private int code;
	private String libelle;
	private List<Produit> produits;

	public Magasin() {

	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
}
