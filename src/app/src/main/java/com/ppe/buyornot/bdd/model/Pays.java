package com.ppe.buyornot.bdd.model;

import android.content.Context;
import android.database.Cursor;

import com.ppe.buyornot.bdd.dao.PaysDao;

import java.util.List;

public class Pays implements IEntity {

	private int code;
	private String libelle;
	private List<Produit> produits;

	public Pays() {

	}

	@Override
	public void createFromCursor(Cursor cursor, Context context) {
		code = cursor.getInt(cursor.getColumnIndex(PaysDao.FIELD_ID));
		libelle = cursor.getString(cursor.getColumnIndex(PaysDao.FIELD_LIBELLE));
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
