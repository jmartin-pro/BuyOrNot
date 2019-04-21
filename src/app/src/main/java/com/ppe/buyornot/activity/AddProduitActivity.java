package com.ppe.buyornot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.ppe.buyornot.bdd.dao.ProduitDao;
import com.ppe.buyornot.bdd.model.Produit;

public class AddProduitActivity extends AbstractProduitActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.buttonDelete.setVisibility(View.GONE);
	}

	@Override
	protected void saveProduit() {
		Produit produit = this.getProduit();

		if(produit == null) {
			Toast.makeText(this, "Tous les champs doivent être remplis!", Toast.LENGTH_LONG).show();
			return;
		}

		ProduitDao produitDao = new ProduitDao(this);
		produitDao.add(produit);
		produitDao.close();

		Intent returnIntent = new Intent();
		setResult(AppCompatActivity.RESULT_OK, returnIntent);

		this.finish();
	}

}
