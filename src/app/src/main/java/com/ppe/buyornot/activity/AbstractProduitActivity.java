package com.ppe.buyornot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.ppe.buyornot.R;
import com.ppe.buyornot.bdd.model.Nova;
import com.ppe.buyornot.bdd.model.Nutriscore;
import com.ppe.buyornot.bdd.model.Produit;

public abstract class AbstractProduitActivity extends AppCompatActivity {

	public static final String EXTRA_PRODUIT_ID = "PRODUIT_ID";

	protected Button buttonDelete;
	protected EditText editTextLibelle;
	protected EditText editTextQuantite;
	protected EditText editTextIngredients;
	protected EditText editTextLien;
	protected EditText editTextEnergie;
	protected EditText editTextFibre;
	protected EditText editTextMatieresGrasses;
	protected EditText editTextAcidesGras;
	protected EditText editTextGlucides;
	protected EditText editTextSucres;
	protected EditText editTextSel;
	protected EditText editTextSodium;
	protected EditText editTextProteine;
	protected EditText editTextCodeEmballeur;
	protected ImageView imageViewNutriscore;
	protected EditText editTextNova;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_produit);

		findViews();
	}

	private void findViews() {
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
	}

	protected Produit getProduit() {
		Produit produit = new Produit();

		produit.setLibelle(editTextLibelle.getText().toString());
		produit.setQuantite(Float.parseFloat(editTextQuantite.getText().toString()));
		produit.setIngredient(editTextIngredients.getText().toString());
		produit.setLien(editTextLien.getText().toString());
		produit.setEnergie(Float.parseFloat(editTextEnergie.getText().toString()));
		produit.setFibre(Float.parseFloat(editTextFibre.getText().toString()));
		produit.setMatiereGrasse(Float.parseFloat(editTextMatieresGrasses.getText().toString()));
		produit.setAcideGras(Float.parseFloat(editTextAcidesGras.getText().toString()));
		produit.setGlucide(Float.parseFloat(editTextGlucides.getText().toString()));
		produit.setSucre(Float.parseFloat(editTextSucres.getText().toString()));
		produit.setSel(Float.parseFloat(editTextSel.getText().toString()));
		produit.setSodium(Float.parseFloat(editTextSodium.getText().toString()));
		produit.setProteine(Float.parseFloat(editTextProteine.getText().toString()));
		//TODO : code emballeur -> produit.setLibelle(Float.parseFloat(editTextLibelle.getText().toString()));
		produit.updateNutriscore();
		produit.setNutriscore(new Nutriscore("A"));
		produit.setNova(new Nova(1));
		//TODO : nova -> produit.setNova(new Nova(editTextLibelle.getText().toString()));

		return produit;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.valid, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.action_valid:
				this.saveProduit();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	protected abstract void saveProduit();
}
