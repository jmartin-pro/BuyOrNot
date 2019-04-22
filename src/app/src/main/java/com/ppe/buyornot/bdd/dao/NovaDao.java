package com.ppe.buyornot.bdd.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ppe.buyornot.bdd.BuyOrNotDatabase;
import com.ppe.buyornot.bdd.model.Nova;

import java.util.ArrayList;
import java.util.List;


public class NovaDao implements IEntityManager<Nova> {
	public static final String TABLE_NAME = "NOVA";

	public static final String FIELD_ID = "NOVA_ID";
	public static final String FIELD_LIBELLE = "NOVA_LIBELLE";
	private final Context context;

	private BuyOrNotDatabase buyOrNotDatabase;
	private SQLiteDatabase db;

	public NovaDao(Context context) {
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

	public List<Nova> getAll() {
		List<Nova> novas = new ArrayList<>();

		Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
		while (c.moveToNext()) {
			Nova n = new Nova();
			n.createFromCursor(c, context);

			novas.add(n);
		}

		return novas;
	}

	public Nova get(int id) {
		Nova n = new Nova();

		Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + FIELD_ID + "=" + id, null);
		if (c.moveToFirst()) {
			n.createFromCursor(c, context);
			c.close();
		}

		return n;
	}

	public long add(Nova nova) {
		ContentValues values = fillContentValues(nova);

		return db.insert(TABLE_NAME, null, values);
	}

	public int update(Nova nova) {
		ContentValues values = fillContentValues(nova);

		String where = FIELD_ID + " = ?";
		String[] whereArgs = {"" + nova.getId()};

		return db.update(TABLE_NAME, values, where, whereArgs);
	}

	public void delete(int id) {
		String where = FIELD_ID + " = ?";
		String[] whereArgs = {"" + id};

		db.delete(TABLE_NAME, where, whereArgs);
	}

	public ContentValues fillContentValues(Nova nova) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(FIELD_LIBELLE, nova.getLibelle());

		return contentValues;
	}
}