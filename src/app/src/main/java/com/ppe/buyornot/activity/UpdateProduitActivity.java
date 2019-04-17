package com.ppe.buyornot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ppe.buyornot.R;
import com.ppe.buyornot.bdd.dao.ProduitDao;
import com.ppe.buyornot.bdd.model.Produit;

public class UpdateProduitActivity extends AppCompatActivity {

	public static final String EXTRA_PRODUIT_ID = "PRODUIT_ID";

	private Button buttonDelete;
	private EditText editTextLibelle;
	private int produitId;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_produit);

		this.produitId = getIntent().getIntExtra(EXTRA_PRODUIT_ID, -1);

		if(this.produitId == -1)
			finish();

		ProduitDao produitDao = new ProduitDao(this);
		Produit produit = produitDao.get(produitId);
		produitDao.close();

		updateUi(produit);
	}

	private void updateUi(Produit produit) {
		this.buttonDelete = findViewById(R.id.delete);
		this.editTextLibelle = findViewById(R.id.libelle);

		editTextLibelle.setText(produit.getLibelle());

		this.buttonDelete.setOnClickListener(new DeleteProduitOnClickListener());
	}

	private class DeleteProduitOnClickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			ProduitDao produitDao = new ProduitDao(UpdateProduitActivity.this);
			produitDao.delete(produitId);
			produitDao.close();

			Intent returnIntent = new Intent();
			setResult(AppCompatActivity.RESULT_OK, returnIntent);

			UpdateProduitActivity.this.finish();
		}
	}
}
