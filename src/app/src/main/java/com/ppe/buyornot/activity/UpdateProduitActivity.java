package com.ppe.buyornot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.ppe.buyornot.R;
import com.ppe.buyornot.bdd.dao.ProduitDao;
import com.ppe.buyornot.bdd.model.Produit;

public class UpdateProduitActivity extends AppCompatActivity {

	public static final String EXTRA_PRODUIT_ID = "PRODUIT_ID";

	private Button buttonDelete;
	private EditText editTextLibelle;
	private EditText editTextQuantite;
	private EditText editTextIngredients;
	private EditText editTextLien;
	private EditText editTextEnergie;
	private EditText editTextFibre;
	private EditText editTextMatieresGrasses;
	private EditText editTextAcidesGras;
	private EditText editTextGlucides;
	private EditText editTextSucres;
	private EditText editTextSel;
	private EditText editTextSodium;
	private EditText editTextProteine;
	private EditText editTextCodeEmballeur;
	private ImageView imageViewNutriscore;
	private EditText editTextNova;

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
		this.editTextQuantite = findViewById(R.id.quantite);
		this.editTextIngredients = findViewById(R.id.ingredients);
		this.editTextLien = findViewById(R.id.lien);
		this.editTextEnergie = findViewById(R.id.energie);
		this.editTextFibre = findViewById(R.id.fibre);
		this.editTextMatieresGrasses = findViewById(R.id.matieresGrasses);
		this.editTextAcidesGras = findViewById(R.id.acidesGras);
		this.editTextGlucides = findViewById(R.id.glucides);
		this.editTextSucres = findViewById(R.id.sucres);
		this.editTextSel = findViewById(R.id.sel);
		this.editTextSodium = findViewById(R.id.sodium);
		this.editTextProteine = findViewById(R.id.proteine);
		this.editTextCodeEmballeur = findViewById(R.id.codeEmballeur);
		this.imageViewNutriscore = findViewById(R.id.nutriscore);
		this.editTextNova = findViewById(R.id.nova);

		editTextLibelle.setText(produit.getLibelle());
		this.editTextQuantite.setText(""+produit.getQuantite());
		this.editTextIngredients.setText(""+produit.getIngredient());
		this.editTextLien.setText(""+produit.getLien());
		this.editTextEnergie.setText(""+produit.getEnergie());
		this.editTextFibre.setText(""+produit.getFibre());
		this.editTextMatieresGrasses.setText(""+produit.getMatiereGrasse());
		this.editTextAcidesGras.setText(""+produit.getAcideGras());
		this.editTextGlucides.setText(""+produit.getGlucide());
		this.editTextSucres.setText(""+produit.getSucre());
		this.editTextSel.setText(""+produit.getSel());
		this.editTextSodium.setText(""+produit.getSodium());
		this.editTextProteine.setText(""+produit.getProteine());
		this.editTextCodeEmballeur.setText(""+produit.getCodeEmballeur());

		String nutriscore = produit.getNutriscore().getCode();
		int nutriscorerawableId = this.getResources().getIdentifier("nutriscore_" + nutriscore.toLowerCase(), "drawable", this.getPackageName());
		this.imageViewNutriscore.setImageDrawable(this.getResources().getDrawable(nutriscorerawableId));

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
