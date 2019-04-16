package com.ppe.buyornot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ppe.buyornot.bdd.dao.PaysDao;
import com.ppe.buyornot.bdd.model.Pays;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		PaysDao paysDao = new PaysDao(this);
		for(Pays p : paysDao.getAll()) {
			System.out.println(p.getLibelle());
		}

		paysDao.close();
	}
}
