package com.ppe.buyornot.bdd.model;

import java.util.List;

public class Additif {

    private int id;
    private String libelle;
    private List<Produit> produits;

    public Additif() {

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
