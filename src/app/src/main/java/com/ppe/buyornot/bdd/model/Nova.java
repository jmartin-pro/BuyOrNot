package com.ppe.buyornot.bdd.model;

import android.content.Context;
import android.database.Cursor;

import com.ppe.buyornot.bdd.dao.NovaDao;

public class Nova implements IEntity {

	private int id;
	private String libelle;
	private Produit produit;

	public Nova() {

	}

	public Nova(int id) {
		this.id = id;
	}

	@Override
	public void createFromCursor(Cursor cursor, Context context) {
		this.id = cursor.getInt(cursor.getColumnIndex(NovaDao.FIELD_ID));
		this.libelle = cursor.getString(cursor.getColumnIndex(NovaDao.FIELD_LIBELLE));
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

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
}
