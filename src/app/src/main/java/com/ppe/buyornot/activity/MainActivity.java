package com.ppe.buyornot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.ppe.buyornot.R;
import com.ppe.buyornot.adapter.ProduitRecyclerAdapter;
import com.ppe.buyornot.bdd.dao.ProduitDao;
import com.ppe.buyornot.bdd.model.Produit;

import java.util.List;

public class MainActivity extends AppCompatActivity {

	public static final int ACTIVITY_CODE_UDPATE_PRODUIT = 1;
	public static final int ACTIVITY_CODE_ADD_PRODUIT = 2;

	private RecyclerView recyclerView;
	private List<Produit> produits;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.recyclerView = findViewById(R.id.recyclerViewProduits);

		this.updateRecyclerView();
	}

	private void updateRecyclerView() {
		ProduitDao produitDao = new ProduitDao(this);
		this.produits = produitDao.getAll();

		ProduitRecyclerAdapter adapter = new ProduitRecyclerAdapter(this.produits, new RowClickListener(), this);
		this.recyclerView.setAdapter(adapter);
		this.recyclerView.setLayoutManager(new LinearLayoutManager(this));

		produitDao.close();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		if (requestCode == ACTIVITY_CODE_UDPATE_PRODUIT) {
			if (resultCode == RESULT_OK) {
				this.updateRecyclerView();
			}
		} else if (requestCode == ACTIVITY_CODE_ADD_PRODUIT) {
			if (resultCode == RESULT_OK) {
				this.updateRecyclerView();
			}
		}
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
				startActivityForResult(intent, ACTIVITY_CODE_ADD_PRODUIT);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	private class RowClickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			int itemPosition = MainActivity.this.recyclerView.getChildLayoutPosition(v);
			int produitId = MainActivity.this.produits.get(itemPosition).getId();

			Intent intent = new Intent(MainActivity.this, UpdateProduitActivity.class);
			intent.putExtra(UpdateProduitActivity.EXTRA_PRODUIT_ID, produitId);
			startActivityForResult(intent, ACTIVITY_CODE_UDPATE_PRODUIT);
		}
	}
}
