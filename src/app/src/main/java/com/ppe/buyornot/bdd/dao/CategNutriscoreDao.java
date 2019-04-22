package com.ppe.buyornot.bdd.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ppe.buyornot.bdd.BuyOrNotDatabase;
import com.ppe.buyornot.bdd.model.CategNutriscore;

import java.util.ArrayList;
import java.util.List;


public class CategNutriscoreDao implements IEntityManager<CategNutriscore> {
	public static final String FIELD_ID = "CN_ID";
	public static final String FIELD_LIBELLE = "CN_LIBELLE";
	private static final String TABLE_NAME = "CATEG_NUTRISCORE";
	private final Context context;

	private BuyOrNotDatabase buyOrNotDatabase;
	private SQLiteDatabase db;

	public CategNutriscoreDao(Context context) {
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

	public List<CategNutriscore> getAll() {
		List<CategNutriscore> categNutriscores = new ArrayList<>();

		Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
		while (c.moveToNext()) {
			CategNutriscore cn = new CategNutriscore();
			cn.createFromCursor(c, context);

			categNutriscores.add(cn);
		}

		return categNutriscores;
	}

	public CategNutriscore get(int id) {
		CategNutriscore cn = new CategNutriscore();

		Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + FIELD_ID + "=" + id, null);
		if (c.moveToFirst()) {
			cn.createFromCursor(c, context);
			c.close();
		}

		return cn;
	}

	public long add(CategNutriscore categNutriscore) {
		ContentValues values = fillContentValues(categNutriscore);

		return db.insert(TABLE_NAME, null, values);
	}

	public int update(CategNutriscore categNutriscore) {
		ContentValues values = fillContentValues(categNutriscore);

		String where = FIELD_ID + " = ?";
		String[] whereArgs = {"" + categNutriscore.getId()};

		return db.update(TABLE_NAME, values, where, whereArgs);
	}

	public void delete(int id) {
		String where = FIELD_ID + " = ?";
		String[] whereArgs = {"" + id};

		db.delete(TABLE_NAME, where, whereArgs);
	}

	public ContentValues fillContentValues(CategNutriscore categNutriscore) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(FIELD_LIBELLE, categNutriscore.getLibelle());

		return contentValues;
	}
}