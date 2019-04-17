package com.ppe.buyornot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.ppe.buyornot.ProduitRecyclerAdapter;
import com.ppe.buyornot.R;
import com.ppe.buyornot.bdd.dao.PaysDao;
import com.ppe.buyornot.bdd.dao.ProduitDao;
import com.ppe.buyornot.bdd.model.Pays;

public class MainActivity extends AppCompatActivity {

	private RecyclerView recyclerView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.recyclerView = findViewById(R.id.recyclerViewProduits);

		ProduitDao produitDao = new ProduitDao(this);

		ProduitRecyclerAdapter adapter = new ProduitRecyclerAdapter(produitDao.getAll(), this);
		this.recyclerView.setAdapter(adapter);
		this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.action_add:
				Intent intent = new Intent(MainActivity.this, AddProduitActivity.class);
				startActivity(intent);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
}
