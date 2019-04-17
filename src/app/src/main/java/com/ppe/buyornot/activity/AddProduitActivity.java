package com.ppe.buyornot.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ppe.buyornot.R;

public class AddProduitActivity extends AppCompatActivity {

	private Button buttonDelete;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_produit);

		this.buttonDelete = findViewById(R.id.delete);
		this.buttonDelete.setVisibility(View.GONE);
	}

}
