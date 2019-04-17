package com.ppe.buyornot.bdd.model;

import android.database.Cursor;

public class Nutriscore implements IEntity {

    private String code;
    private String libelle;
    private Produit produit;

    public Nutriscore(){

    }

	public Nutriscore(String code) {
        this.code = code;
	}

	@Override
    public void createFromCursor(Cursor cursor) {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
