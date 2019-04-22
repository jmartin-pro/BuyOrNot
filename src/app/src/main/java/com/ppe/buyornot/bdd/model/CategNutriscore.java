package com.ppe.buyornot.bdd.model;

import android.content.Context;
import android.database.Cursor;

import com.ppe.buyornot.bdd.dao.CategNutriscoreDao;
import com.ppe.buyornot.bdd.dao.PaysDao;

import java.util.List;

public class CategNutriscore implements IEntity {

	private int id;
	private String libelle;
	private List<Produit> produits;

	public CategNutriscore() {

	}

	@Override
	public void createFromCursor(Cursor cursor, Context context) {
		id = cursor.getInt(cursor.getColumnIndex(CategNutriscoreDao.FIELD_ID));
		libelle = cursor.getString(cursor.getColumnIndex(CategNutriscoreDao.FIELD_LIBELLE));
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
