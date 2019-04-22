package com.ppe.buyornot.bdd.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ppe.buyornot.bdd.BuyOrNotDatabase;
import com.ppe.buyornot.bdd.model.Produit;

import java.util.ArrayList;
import java.util.List;


public class ProduitDao implements IEntityManager<Produit> {
	public static final String FIELD_ID = "PRO_ID";
	public static final String FIELD_LIBELLE = "PRO_LIBELLE";
	public static final String FIELD_ID_CODE_EMBALLEUR = "COD_ID";
	public static final String FIELD_ID_NOVA = "NOVA_ID";
	public static final String FIELD_ID_NUTRISCORE = "NUT_CODE";
	public static final String FIELD_INGREDIENT = "PRO_INGREDIENT";
	public static final String FIELD_LIEN = "PRO_LIEN";
	public static final String FIELD_QUANTITE = "PRO_QUANTITE";
	public static final String FIELD_ENERGIE = "PRO_ENERGIE";
	public static final String FIELD_MATIERE_GRASSE = "PRO_MATIEREGRASSE";
	public static final String FIELD_ACIDE_GRAS = "PRO_ACIDEGRAS";
	public static final String FIELD_GLUCIDE = "PRO_GLUCIDE";
	public static final String FIELD_SUCRE = "PRO_SUCRE";
	public static final String FIELD_FIBRE = "PRO_FIBRE";
	public static final String FIELD_PROTEINE = "PRO_PROTEINE";
	public static final String FIELD_SEL = "PRO_SEL";
	public static final String FIELD_SODIUM = "PRO_SODIUM";
	public static final String FIELD_FRUITS = "PRO_FRUIT";
	private static final String TABLE_NAME = "PRODUIT";

	private final Context context;

	private BuyOrNotDatabase buyOrNotDatabase;
	private SQLiteDatabase db;

	public ProduitDao(Context context) {
		buyOrNotDatabase = BuyOrNotDatabase.getInstance(context);
		this.open();

		this.context = context;
	}

	public void open() {
		db = buyOrNotDatabase.getWritableDatabase();
	}

	public void close() {
		db.close();
	}

	public List<Produit> getAll() {
		return getAll(FIELD_ID);
	}

	public List<Produit> getAll(String orderbyClause) {
		List<Produit> produits = new ArrayList<>();

		Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY "+orderbyClause, null);
		while (c.moveToNext()) {
			Produit p = new Produit();
			p.createFromCursor(c, this.context);

			produits.add(p);
		}

		return produits;
	}

	public Produit get(int id) {
		Produit p = new Produit();

		Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + FIELD_ID + "=" + id, null);
		if (c.moveToFirst()) {
			p.createFromCursor(c, this.context);
			c.close();
		}

		return p;
	}

	public long add(Produit produit) {
		ContentValues values = fillContentValues(produit);

		return db.insert(TABLE_NAME, null, values);
	}

	public int update(Produit produit) {
		ContentValues values = fillContentValues(produit);

		String where = FIELD_ID + " = ?";
		String[] whereArgs = {"" + produit.getId()};

		return db.update(TABLE_NAME, values, where, whereArgs);
	}

	public void delete(int id) {
		String where = FIELD_ID + " = ?";
		String[] whereArgs = {"" + id};

		db.delete(TABLE_NAME, where, whereArgs);
	}

	public ContentValues fillContentValues(Produit produit) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(FIELD_LIBELLE, produit.getLibelle());
		if (produit.getCodeEmballeur() != null)
			contentValues.put(FIELD_ID_CODE_EMBALLEUR, produit.getCodeEmballeur().getId());
		else
			contentValues.putNull(FIELD_ID_CODE_EMBALLEUR);

		if (produit.getNova() != null)
			contentValues.put(FIELD_ID_NOVA, produit.getNova().getId());
		else
			contentValues.putNull(FIELD_ID_NOVA);

		if (produit.getNutriscore() != null)
			contentValues.put(FIELD_ID_NUTRISCORE, produit.getNutriscore().getCode());
		else
			contentValues.putNull(FIELD_ID_NUTRISCORE);

		contentValues.put(FIELD_INGREDIENT, produit.getIngredient());
		contentValues.put(FIELD_LIEN, produit.getLien());
		contentValues.put(FIELD_QUANTITE, produit.getQuantite());
		contentValues.put(FIELD_ENERGIE, produit.getEnergie());
		contentValues.put(FIELD_MATIERE_GRASSE, produit.getMatiereGrasse());
		contentValues.put(FIELD_ACIDE_GRAS, produit.getAcideGras());
		contentValues.put(FIELD_GLUCIDE, produit.getGlucide());
		contentValues.put(FIELD_SUCRE, produit.getSucre());
		contentValues.put(FIELD_FIBRE, produit.getFibre());
		contentValues.put(FIELD_PROTEINE, produit.getProteine());
		contentValues.put(FIELD_SEL, produit.getSel());
		contentValues.put(FIELD_SODIUM, produit.getSodium());
		contentValues.put(FIELD_FRUITS, produit.getFruits());

		return contentValues;
	}
}