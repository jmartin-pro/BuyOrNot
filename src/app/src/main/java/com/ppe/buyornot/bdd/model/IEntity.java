package com.ppe.buyornot.bdd.model;

import android.content.Context;
import android.database.Cursor;

public interface IEntity {
	void createFromCursor(Cursor cursor, Context context);
}
