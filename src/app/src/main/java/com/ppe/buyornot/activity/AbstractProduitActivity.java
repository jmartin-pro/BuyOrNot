package com.ppe.buyornot.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.ppe.buyornot.R;
import com.ppe.buyornot.bdd.dao.NovaDao;
import com.ppe.buyornot.bdd.model.Nova;
import com.ppe.buyornot.bdd.model.Nutriscore;
import com.ppe.buyornot.bdd.model.Produit;

import java.util.ArrayList;
import java.util.List;

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
	protected Spinner spinnerNova;

	protected List<Nova> novas;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_produit);

		findViews();

		NovaDao novaDao = new NovaDao(this);
		novas = novaDao.getAll();

		List<String> novasStr = new ArrayList<>();
		for(Nova n : this.novas)
			novasStr.add(n.getLibelle());

		ArrayAdapter<String> novaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, novasStr);
		novaDao.close();

		spinnerNova.setAdapter(novaAdapter);
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
		this.spinnerNova = findViewById(R.id.nova);
	}

	protected Produit getProduit() {
		if(this.editTextLibelle.getText().toString().isEmpty() ||
			this.editTextQuantite.getText().toString().isEmpty() ||
			this.editTextIngredients.getText().toString().isEmpty() ||
			this.editTextLien.getText().toString().isEmpty() ||
			this.editTextEnergie.getText().toString().isEmpty() ||
			this.editTextFibre.getText().toString().isEmpty() ||
			this.editTextMatieresGrasses.getText().toString().isEmpty() ||
			this.editTextAcidesGras.getText().toString().isEmpty() ||
			this.editTextGlucides.getText().toString().isEmpty() ||
			this.editTextSucres.getText().toString().isEmpty() ||
			this.editTextSel.getText().toString().isEmpty() ||
			this.editTextSodium.getText().toString().isEmpty() ||
			this.editTextProteine.getText().toString().isEmpty() ||
			this.editTextCodeEmballeur.getText().toString().isEmpty()) {

			return null;
		}

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

		produit.setNova(novas.get((int) spinnerNova.getSelectedItemId()));

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
