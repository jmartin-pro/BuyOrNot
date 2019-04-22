package com.ppe.buyornot.util;

import com.ppe.buyornot.bdd.model.Nutriscore;
import com.ppe.buyornot.bdd.model.Produit;

import java.util.Arrays;
import java.util.List;

public class NutriscoreCalculator {

	private static final int ID_AUTRE = 1;
	private static final int ID_MATIERE_GRASSE = 2;
	private static final int ID_BOISSON = 3;
	private static final int ID_FROMAGE = 4;
	private static final int ID_EAUX_MINERALES_SOURCE = 5;

	public static Nutriscore getNutriscore(Produit p) {
		if(p.getCategNutriscore().getId() == ID_EAUX_MINERALES_SOURCE) {
			return new Nutriscore("A");
		}

		List<Float> seuilsEnergie = Arrays.asList(335f, 670f, 1005f, 1340f, 1675f, 2010f, 2345f, 2680f, 3015f, 3350f);
		List<Float> seuilsGraisses = Arrays.asList(1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f);
		List<Float> seuilsSucres = Arrays.asList(4.5f, 9f, 13.5f, 18f, 22.5f, 27f, 31f, 36f, 40f, 45f);
		List<Float> seuilsSodium = Arrays.asList(90f, 180f, 270f, 360f, 450f, 540f, 630f, 720f, 810f, 900f);
		List<Float> seuilsFibre = Arrays.asList(0.9f, 1.9f, 2.8f, 3.7f, 4.7f);
		List<Float> seuilsFruits = Arrays.asList(40f, 60f, 80f, 80f, 80f);
		List<Float> seuilsProteine = Arrays.asList(1.6f, 3.2f, 4.8f, 6.4f, 8.0f);

		List<Float> seuilsGraissesMatiereGrasse = Arrays.asList(10f, 16f, 22f, 28f, 34f, 40f, 46f, 52f, 58f, 64f);

		List<Float> seuilsEnergieBoisson = Arrays.asList(0f, 30f, 60f, 90f, 120f, 150f, 180f, 210f, 240f, 270f);
		List<Float> seuilsSucresBoisson = Arrays.asList(0.0f, 1.5f, 3f, 4.5f, 6f, 7.5f, 9f, 10.5f, 12f, 13.5f);
		List<Float> seuilsFruitsBoisson = Arrays.asList(40f, 40f, 60f, 60f, 80f, 80f, 80f, 80f, 80f, 80f);


		int pointsEnergie = (p.getCategNutriscore().getId() == ID_BOISSON) ? getPoints(seuilsEnergieBoisson, p.getEnergie()) : getPoints(seuilsEnergie, p.getEnergie());
		//TODO : Vérifier pour les lipides en cas de produit à matière grasse
		int pointsGraisses = (p.getCategNutriscore().getId() == ID_MATIERE_GRASSE) ? getPoints(seuilsGraissesMatiereGrasse, p.getMatiereGrasse()) : getPoints(seuilsGraisses, p.getMatiereGrasse());
		int pointsSucre = (p.getCategNutriscore().getId() == ID_BOISSON) ? getPoints(seuilsSucresBoisson, p.getSucre()) : getPoints(seuilsSucres, p.getSucre());
		int pointsSodium = getPoints(seuilsSodium, p.getSodium());
		int pointsFruits = (p.getCategNutriscore().getId() == ID_BOISSON) ? getPoints(seuilsFruitsBoisson, p.getFruits()) : getPoints(seuilsFruits, p.getFruits());
		int pointsFibre = getPoints(seuilsFibre, p.getFibre());
		int pointsProteine = getPoints(seuilsProteine, p.getProteine());

		int score = calculerScore(p, pointsEnergie, pointsGraisses, pointsSucre, pointsSodium, pointsFruits, pointsFibre, pointsProteine);

		return getNutriscore(score, p.getCategNutriscore().getId() == ID_BOISSON);
	}

	private static int getPoints(List<Float> seuils, float valeur) {
		for(int i = 0 ; i < seuils.size() ; i++) {
			if(valeur < seuils.get(i))
				return i;
		}

		return seuils.size();
	}

	private static int calculerScore(Produit p, int pointsEnergie, int pointsGraisses, int pointsSucre, int pointsSodium, int pointsFruits, int pointsFibre, int pointsProteine) {
		int pointsA = pointsEnergie + pointsGraisses + pointsSucre + pointsSodium;
		int pointsC = pointsFruits + pointsFibre + pointsProteine;

		if(p.getCategNutriscore().getId() == ID_FROMAGE) {
			pointsC -= pointsProteine;
			pointsA -= pointsProteine;
		}

		int score = 0;

		if(pointsA < 11 || pointsFruits == 5) {
			score = pointsA - pointsC;
		} else if(pointsFruits < 5){
			score = pointsA - (pointsFibre + pointsFruits);
		}

		return score;
	}

	private static Nutriscore getNutriscore(int score, boolean boisson) {
		if(boisson) {
			if(score <= 1)
				return new Nutriscore("B");
			else if(score <= 5)
				return new Nutriscore("C");
			else if(score <= 9)
				return new Nutriscore("D");
			else
				return new Nutriscore("E");
		} else {
			if(score <= -1)
				return new Nutriscore("A");
			else if(score <= 2)
				return new Nutriscore("B");
			else if(score <= 10)
				return new Nutriscore("C");
			else if(score <= 18)
				return new Nutriscore("D");
			else
				return new Nutriscore("E");
		}
	}
}
