package com.ppe.buyornot.bdd.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ppe.buyornot.bdd.BuyOrNotDatabase;
import com.ppe.buyornot.bdd.model.Pays;

import java.util.ArrayList;
import java.util.List;


public class PaysDao implements IEntityManager<Pays> {
    private static final String TABLE_NAME = "PAYS";

    public static final String FIELD_ID = "PAY_CODE";
    public static final String FIELD_LIBELLE = "PAY_LIBELLE";

    private BuyOrNotDatabase buyOrNotDatabase;
    private SQLiteDatabase db;

    public PaysDao(Context context) {
        buyOrNotDatabase = BuyOrNotDatabase.getInstance(context);
        this.open();
    }

    public void open() {
        db = buyOrNotDatabase.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public List<Pays> getAll() {
        List<Pays> pays = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        while(c.moveToNext()) {
            Pays p = new Pays();
            p.createFromCursor(c);

            pays.add(p);
        }

        return pays;
    }

    public Pays get(int id) {
        Pays p = new Pays();

        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+FIELD_ID+"="+id, null);
        if (c.moveToFirst()) {
            p.createFromCursor(c);
            c.close();
        }

        return p;
    }

    public long add(Pays pays) {
        ContentValues values = fillContentValues(pays);

        return db.insert(TABLE_NAME, null, values);
    }

    public int update(Pays pays) {
        ContentValues values = fillContentValues(pays);

        String where = FIELD_ID +" = ?";
        String[] whereArgs = {""+pays.getCode()};

        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public void delete(int id) {
        String where = FIELD_ID +" = ?";
        String[] whereArgs = {""+id};

        db.delete(TABLE_NAME, where, whereArgs);
    }

    public ContentValues fillContentValues(Pays pays) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(FIELD_LIBELLE, pays.getLibelle());

        return contentValues;
    }
}