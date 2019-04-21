package com.ppe.buyornot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ppe.buyornot.bdd.dao.ProduitDao;

public class AddProduitActivity extends AbstractProduitActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.buttonDelete.setVisibility(View.GONE);
	}

	@Override
	protected void saveProduit() {
		ProduitDao produitDao = new ProduitDao(this);
		produitDao.add(this.getProduit());
		produitDao.close();

		Intent returnIntent = new Intent();
		setResult(AppCompatActivity.RESULT_OK, returnIntent);

		this.finish();
	}

}
