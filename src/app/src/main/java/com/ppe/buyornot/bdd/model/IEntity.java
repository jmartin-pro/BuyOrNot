package com.ppe.buyornot.bdd.model;

import android.database.Cursor;

public interface IEntity {
	void createFromCursor(Cursor cursor);
}
