package com.ppe.buyornot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.ppe.buyornot.bdd.dao.ProduitDao;
import com.ppe.buyornot.bdd.model.Produit;

public class UpdateProduitActivity extends AbstractProduitActivity {

	public static final String EXTRA_PRODUIT_ID = "PRODUIT_ID";

	private int produitId;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.produitId = getIntent().getIntExtra(EXTRA_PRODUIT_ID, -1);

		if(this.produitId == -1)
			finish();

		ProduitDao produitDao = new ProduitDao(this);
		Produit produit = produitDao.get(produitId);
		produitDao.close();

		updateUi(produit);
	}

	private void updateUi(Produit produit) {
		editTextLibelle.setText(produit.getLibelle());
		this.editTextQuantite.setText(""+produit.getQuantite());
		this.editTextIngredients.setText((produit.getIngredient() != null) ? ""+produit.getIngredient() : "");
		this.editTextLien.setText((produit.getLien() != null) ? ""+produit.getLien() : "");
		this.editTextEnergie.setText(""+produit.getEnergie());
		this.editTextFibre.setText(""+produit.getFibre());
		this.editTextMatieresGrasses.setText(""+produit.getMatiereGrasse());
		this.editTextAcidesGras.setText(""+produit.getAcideGras());
		this.editTextGlucides.setText(""+produit.getGlucide());
		this.editTextSucres.setText(""+produit.getSucre());
		this.editTextSel.setText(""+produit.getSel());
		this.editTextSodium.setText(""+produit.getSodium());
		this.editTextProteine.setText(""+produit.getProteine());
		this.editTextFruit.setText(""+produit.getFruits());

		if(produit.getCodeEmballeur() != null) {
			for (int i = 0; i < this.codeEmballeurs.size(); i++) {
				if (this.codeEmballeurs.get(i).getId() == produit.getCodeEmballeur().getId()) {
					this.spinnerCodeEmballeur.setSelection(i+1);

					break;
				}
			}
		}

		for(int i = 0 ; i < this.novas.size() ; i++) {
			if(this.novas.get(i).getId() == produit.getNova().getId()) {
				this.spinnerNova.setSelection(i);

				break;
			}
		}

		this.buttonDelete.setOnClickListener(new DeleteProduitOnClickListener());
	}

	@Override
	protected void saveProduit() {
		ProduitDao produitDao = new ProduitDao(this);

		Produit produit = this.getProduit();
		if(produit == null) {
			Toast.makeText(this, "Tous les champs doivent être remplis!", Toast.LENGTH_LONG).show();
			return;
		}

		produit.setId(this.produitId);

		produitDao.update(produit);
		produitDao.close();

		Intent returnIntent = new Intent();
		setResult(AppCompatActivity.RESULT_OK, returnIntent);

		this.finish();
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
