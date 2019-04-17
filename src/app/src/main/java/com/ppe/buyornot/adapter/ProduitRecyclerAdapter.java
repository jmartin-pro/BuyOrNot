package com.ppe.buyornot.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ppe.buyornot.R;
import com.ppe.buyornot.bdd.model.Produit;

import java.util.List;

public class ProduitRecyclerAdapter extends RecyclerView.Adapter<ProduitRecyclerAdapter.ViewHolder> {

	private Context context;
	private List<Produit> produits;
	private View.OnClickListener rowClickLister;

	public ProduitRecyclerAdapter(List<Produit> produits, View.OnClickListener rowClickListener, Context context) {
		this.produits = produits;
		this.context = context;
		this.rowClickLister = rowClickListener;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

		View row = inflater.inflate(R.layout.row_produit, viewGroup, false);

		row.setOnClickListener(this.rowClickLister);

		return new ViewHolder(row);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
		Produit p = this.produits.get(i);

		viewHolder.textViewLibelle.setText(p.getLibelle());

		String nutriscore = p.getNutriscore().getCode();
		int nutriscorerawableId = context.getResources().getIdentifier("nutriscore_" + nutriscore.toLowerCase(), "drawable", context.getPackageName());
		viewHolder.imageViewNutriscore.setImageDrawable(context.getResources().getDrawable(nutriscorerawableId));
	}

	@Override
	public int getItemCount() {
		return this.produits.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		public TextView textViewLibelle;
		public ImageView imageViewNutriscore;

		public ViewHolder(View itemView) {
			super(itemView);

			this.textViewLibelle = itemView.findViewById(R.id.libelleProduit);
			this.imageViewNutriscore = itemView.findViewById(R.id.nutriScoreProduit);
		}
	}
}