package com.ppe.buyornot.bdd.model;

import java.util.List;

public class Produit {
    private int id;
    private String libelle;
    private String ingredient;
    private String lien;
    private float quantite;
    private float energie;
    private float matiereGrasse;
    private float acideGras;
    private float glucide;
    private float sucre;
    private float fibre;
    private float proteine;
    private float sel;
    private float sodium;
    private List<Additif> additifs;
    private CodeEmballeur codeEmballeur;
    private List<Marque> marques;
    private List<Pays> vendre;
    private List<Pays> provenir;
    private List<Label> labels;
    private List<Categorie> categories;
    private List<Magasin> magasins;
    private List<Lieu> lieuxFabrication;
    private Nutriscore nutriscore;
    private Nova nova;
    private List<Conditionnement> conditionnements;
    private List<Allergene> allergenes;

    public Produit() {

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

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public float getQuantite() {
        return quantite;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    public float getEnergie() {
        return energie;
    }

    public void setEnergie(float energie) {
        this.energie = energie;
    }

    public float getMatiereGrasse() {
        return matiereGrasse;
    }

    public void setMatiereGrasse(float matiereGrasse) {
        this.matiereGrasse = matiereGrasse;
    }

    public float getAcideGras() {
        return acideGras;
    }

    public void setAcideGras(float acideGras) {
        this.acideGras = acideGras;
    }

    public float getGlucide() {
        return glucide;
    }

    public void setGlucide(float glucide) {
        this.glucide = glucide;
    }

    public float getSucre() {
        return sucre;
    }

    public void setSucre(float sucre) {
        this.sucre = sucre;
    }

    public float getFibre() {
        return fibre;
    }

    public void setFibre(float fibre) {
        this.fibre = fibre;
    }

    public float getProteine() {
        return proteine;
    }

    public void setProteine(float proteine) {
        this.proteine = proteine;
    }

    public float getSel() {
        return sel;
    }

    public void setSel(float sel) {
        this.sel = sel;
    }

    public float getSodium() {
        return sodium;
    }

    public void setSodium(float sodium) {
        this.sodium = sodium;
    }

    public List<Additif> getAdditifs() {
        return additifs;
    }

    public void setAdditifs(List<Additif> additifs) {
        this.additifs = additifs;
    }

    public CodeEmballeur getCodeEmballeur() {
        return codeEmballeur;
    }

    public void setCodeEmballeur(CodeEmballeur codeEmballeur) {
        this.codeEmballeur = codeEmballeur;
    }

    public List<Marque> getMarques() {
        return marques;
    }

    public void setMarques(List<Marque> marques) {
        this.marques = marques;
    }

    public List<Pays> getVendre() {
        return vendre;
    }

    public void setVendre(List<Pays> vendre) {
        this.vendre = vendre;
    }

    public List<Pays> getProvenir() {
        return provenir;
    }

    public void setProvenir(List<Pays> provenir) {
        this.provenir = provenir;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    public List<Magasin> getMagasins() {
        return magasins;
    }

    public void setMagasins(List<Magasin> magasins) {
        this.magasins = magasins;
    }

    public List<Lieu> getLieuxFabrication() {
        return lieuxFabrication;
    }

    public void setLieuxFabrication(List<Lieu> lieuxFabrication) {
        this.lieuxFabrication = lieuxFabrication;
    }

    public Nutriscore getNutriscore() {
        return nutriscore;
    }

    public void setNutriscore(Nutriscore nutriscore) {
        this.nutriscore = nutriscore;
    }

    public Nova getNova() {
        return nova;
    }

    public void setNova(Nova nova) {
        this.nova = nova;
    }

    public List<Conditionnement> getConditionnements() {
        return conditionnements;
    }

    public void setConditionnements(List<Conditionnement> conditionnements) {
        this.conditionnements = conditionnements;
    }

    public List<Allergene> getAllergenes() {
        return allergenes;
    }

    public void setAllergenes(List<Allergene> allergenes) {
        this.allergenes = allergenes;
    }
}
