package com.ppe.buyornot.bdd;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuyOrNotDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "BuyOrNot.db";
    private static final int DATABASE_VERSION = 2;

    private static SQLiteOpenHelper instance;

    private Context context;

    public static synchronized BuyOrNotDatabase getInstance(Context context) {
        if (instance == null) {
            instance = new BuyOrNotDatabase(context);
        }

        return (BuyOrNotDatabase) instance;
    }

    private BuyOrNotDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    	onUpgrade(sqLiteDatabase, 1, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
		if(oldVersion == 1) {
			execFile(sqLiteDatabase, "1_struct.sql");
			oldVersion++;
		}

		if(oldVersion == 2) {
			execFile(sqLiteDatabase, "2_data.sql");
			oldVersion++;
		}

		System.out.println("Yeah!");

    }

    private void execFile(SQLiteDatabase sqLiteDatabase, String path) {
        BufferedReader input = null;
        StringBuilder fileContent = new StringBuilder();
        try {
            input = new BufferedReader(new InputStreamReader(context.getAssets().open(path)));

            String line;
            while ((line = input.readLine()) != null) {
                fileContent.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
        	for(String query : fileContent.toString().split(";"))
        		sqLiteDatabase.execSQL(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}