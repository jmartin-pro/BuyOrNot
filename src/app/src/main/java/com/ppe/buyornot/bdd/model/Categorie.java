package com.ppe.buyornot.bdd.model;

import android.database.Cursor;

import java.util.List;

public class Categorie implements IEntity {

	private int code;
	private String libelle;
	private List<Produit> produits;

	public Categorie() {

	}

	@Override
	public void createFromCursor(Cursor cursor) {

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
