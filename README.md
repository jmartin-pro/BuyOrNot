# Présentation

Open Food Facts est une base de données de produits alimentaires qui répertorie les ingrédients, les allergènes, la composition nutritionnelle et toutes les informations présentes sur les étiquettes des aliments.

Actuellement la gestion de cette base de donnée s’effectue sans application dédié, manuellement par l’administrateur de base de donnée de l’association.

Devant le succès de cette application et souhaitant que cette base de données soit collaborative, libre et ouverte des produits alimentaires du monde entier, Open Food Facts a décidé de créer une application mobile Android sous Android Studio pour la gestion de sa base de données.

# Fonctionnalités souhaitées de l'application

Tout d’abord vous devez créer une BDD SQLite pour effectuer dans un premier temps une version beta d’un module de l’application en local.
- Créer une classe qui hérite de SQLiteOpenHelper pour la création de votre BDD
- Afficher, insérer, modifier et supprimer un produit.
- Pour chaque table de votre base, créez une classe Java pour définir chaque enregistrement
- Pour chaque table, créez une classe Java pour gérer l’accès aux données
- Créer une méthode pour le calcul du score nutritionnel en fonction du produit (cf dossier documentaire)
- Les produits pourront être afficher soit
	- par ordre d’ajout du plus récent au moins récent (par défaut)
	- par Nutri-Score
	- par classification Nova
	- par classification Nutri-Score et Nova
	- par libellé du produit
- Une liste de produit sont à ajouter dans la base de données pour les besoins de tests de l’application mobile (cf dossier documentaire)

# Structuration du projet

Le projet comporte 3 dossiers :
- doc → Regroupe les différents documents importants du projet
- sql → Contient l'historique de tous les scripts SQL qui ont modifié la BDD.
- src → Contient le code source de l'application

Le Trello utilisé pour le projet est disponible ici : https://trello.com/b/HCXYRgZp/buy-or-not

# Bibliothèques/Framework utilisées

- [Android SDK](https://developer.android.com/studio/)
- [LaTex](https://www.latex-project.org/) (pour la documentation)

