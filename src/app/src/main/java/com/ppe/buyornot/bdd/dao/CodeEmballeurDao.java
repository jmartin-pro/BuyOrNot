package com.ppe.buyornot.bdd.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ppe.buyornot.bdd.BuyOrNotDatabase;
import com.ppe.buyornot.bdd.model.CodeEmballeur;

import java.util.ArrayList;
import java.util.List;


public class CodeEmballeurDao implements IEntityManager<CodeEmballeur> {
	public static final String TABLE_NAME = "CODEEMBALLEUR";

	public static final String FIELD_ID = "COD_ID";
	public static final String FIELD_LIBELLE = "COD_LIBELLE";
	private final Context context;

	private BuyOrNotDatabase buyOrNotDatabase;
	private SQLiteDatabase db;

	public CodeEmballeurDao(Context context) {
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

	public List<CodeEmballeur> getAll() {
		List<CodeEmballeur> codeEmballeurs = new ArrayList<>();

		Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
		while (c.moveToNext()) {
			CodeEmballeur ce = new CodeEmballeur();
			ce.createFromCursor(c, context);

			codeEmballeurs.add(ce);
		}

		return codeEmballeurs;
	}

	public CodeEmballeur get(int id) {
		CodeEmballeur ce = new CodeEmballeur();

		Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + FIELD_ID + "=" + id, null);
		if (c.moveToFirst()) {
			ce.createFromCursor(c, context);
			c.close();
		}

		return ce;
	}

	public long add(CodeEmballeur codeEmballeur) {
		ContentValues values = fillContentValues(codeEmballeur);

		return db.insert(TABLE_NAME, null, values);
	}

	public int update(CodeEmballeur codeEmballeur) {
		ContentValues values = fillContentValues(codeEmballeur);

		String where = FIELD_ID + " = ?";
		String[] whereArgs = {"" + codeEmballeur.getId()};

		return db.update(TABLE_NAME, values, where, whereArgs);
	}

	public void delete(int id) {
		String where = FIELD_ID + " = ?";
		String[] whereArgs = {"" + id};

		db.delete(TABLE_NAME, where, whereArgs);
	}

	public ContentValues fillContentValues(CodeEmballeur codeEmballeur) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(FIELD_LIBELLE, codeEmballeur.getLibelle());

		return contentValues;
	}
}