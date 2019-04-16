package com.ppe.buyornot.bdd.model;

import android.database.Cursor;

import java.util.List;

public class Additif implements IEntity {

    private int id;
    private String libelle;
    private List<Produit> produits;

    public Additif() {

    }

    @Override
    public void createFromCursor(Cursor cursor) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
