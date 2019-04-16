--
-- Déchargement des données de la table `ADDITIF`
--

INSERT INTO `ADDITIF` (`ADD_ID`, `ADD_LIBELLE`) VALUES
(1, 'E322 - Lécithines'),
(2, 'E451 - Triphosphates'),
(3, 'E407 - Carraghénanes'),
(4, 'E316 - Erythorbate de sodium'),
(5, 'E250 - Nitrite de sodium'),
(6, 'E579 - Gluconate ferreux'),
(7, 'E220 - Anhydride sulfureux'),
(8, 'E301 - Ascorbate de sodium');

--
-- Déchargement des données de la table `ALLERGENE`
--

INSERT INTO `ALLERGENE` (`ALL_CODE`, `ALL_LIBELLE`) VALUES
('1', 'Lait'),
('2', 'Fruits à coque'),
('3', 'Soja'),
('4', 'Gluten'),
('5', 'Œufs'),
('6', 'Céleri'),
('7', ' Moutarde'),
('8', 'Graines de sésame'),
('9', 'Anhydride sulfureux et sulfites');

--
-- Déchargement des données de la table `CATEGORIE`
--

INSERT INTO `CATEGORIE` (`CAT_CODE`, `CAT_LIBELLE`) VALUES
('1', ' Desserts'),
('10', ' Pâtes à tartiner au chocolat'),
('11', ' Pâtes à tartiner aux noisettes et au cacao'),
('14', ' Snacks'),
('16', ' Snacks salés'),
('17', ' Apéritif'),
('18', ' Chips et frites'),
('19', ' Chips'),
('2', ' Puddings'),
('20', ' Chips de pommes de terre'),
('21', ' Chips de pommes de terre à l''huile de tournesol'),
('22', ' Plats préparés'),
('23', ' Produits à la viande'),
('24', ' Plats préparés à la viande'),
('25', ' Pizzas tartes salées et quiches'),
('26', ' Réfrigérés'),
('27', ' Pizzas'),
('28', ' Plats au porc'),
('29', ' Plats préparés réfrigérés'),
('3', ' Riz au lait'),
('30', ' Pizzas au jambon'),
('32', ' Volailles'),
('33', ' Volailles de Loué'),
('34', ' Poulets entiers'),
('35', ' Poulets fermiers'),
('36', ' Produits laitiers'),
('37', ' Produits fermentés'),
('38', ' Produits laitiers fermentés'),
('39', ' Fromages'),
('4', ' Teurgoules'),
('40', ' Fromages de vache'),
('41', ' Fromages de France'),
('42', ' Fromages à pâte molle à croûte fleurie'),
('43', ' Camemberts'),
('44', ' Fromages au lait cru'),
('45', ' Camemberts au lait cru'),
('46', ' Camemberts de Normandie'),
('49', ' Céréales et pommes de terre'),
('5', ' Produits à tartiner'),
('50', ' Graines'),
('51', ' Céréales et dérivés'),
('52', ' Céréales en grains'),
('53', ' Riz'),
('54', ' Riz parfumés'),
('55', ' Riz de variété indica'),
('56', ' Riz long grain'),
('57', ' Riz thaï'),
('58', ' Aliments et boissons à base de végétaux'),
('59', ' Aliments d''origine végétale'),
('6', ' Petit-déjeuners'),
('62', ' Pâtes alimentaires'),
('63', ' Pâtes sèches'),
('64', ' Nouilles'),
('65', ' Pâtes aux œufs'),
('66', ' Tagliatelles'),
('67', ' Pâtes sèches aux œufs'),
('68', ' Nouilles aux oeufs'),
('69', ' Tagliatelles aux œufs'),
('7', ' Produits à tartiner sucrés'),
('70', ' Boissons'),
('71', ' Eaux'),
('72', ' Eaux de sources'),
('73', ' Eaux minérales'),
('74', ' Boissons sans alcool'),
('75', ' Boissons sans sucre ajouté'),
('76', ' Matières grasses'),
('77', ' Sandwichs'),
('78', ' Hamburgers'),
('79', ' Viandes'),
('8', ' Pâtes à tartiner'),
('80', ' Charcuteries'),
('81', ' Jambons'),
('82', ' Jambons blancs'),
('9', ' Pâtes à tartiner aux noisettes');

--
-- Déchargement des données de la table `CODEEMBALLEUR`
--

INSERT INTO `CODEEMBALLEUR` (`COD_ID`, `COD_LIBELLE`) VALUES
(1, ' FR 72.168.001 CE'),
(2, 'FR 14.064.001 CE'),
(3, 'EMB 44068A'),
(4, 'EMB 59457'),
(5, 'FR 59.597.001 CE');

--
-- Déchargement des données de la table `CONDITIONNEMENT`
--

INSERT INTO `CONDITIONNEMENT` (`CON_CODE`, `CON_LIBELLE`) VALUES
('1', ' Pot verre'),
('13', ' Bois'),
('15', ' Frais'),
('16', ' Boîte'),
('18', ' Sachet plastique'),
('19', ' Bouteille'),
('2', ' couvercle plastique'),
('21', ' Carton'),
('22', ' 21 PAP'),
('25', ' Barquette'),
('26', ' Plastique'),
('3', ' Pot'),
('4', ' Sachet'),
('9', ' Sous-vide');

--
-- Déchargement des données de la table `LABEL`
--

INSERT INTO `LABEL` (`LAB_CODE`, `LAB_LIBELLE`) VALUES
('1', ' Sans gluten'),
('10', ' Point Vert'),
('11', ' Label Rouge'),
('12', ' Fabriqué en France'),
('13', ' Origine France'),
('14', ' 84 jours d''élevage minimum'),
('15', ' Elevé en liberté'),
('16', ' Concours général agricole'),
('17', ' AOP'),
('18', ' Médaille d''or du Concours général agricole'),
('19', ' Médaille d''or du concours général agricole 2015'),
('20', ' Moulé à la main'),
('22', ' Importé d''Italie'),
('23', ' Sans-nirate'),
('24', ' Bio'),
('25', ' Bio européen'),
('26', ' Agriculture UE/Non UE'),
('27', ' FR-BIO-10'),
('28', ' Qualité supérieure'),
('29', ' Alimentation controlée'),
('30', ' Elevages sélectionnés'),
('31', ' Qualité garantie'),
('32', ' Traçabilité garantie'),
('4', ' Sans colorants'),
('5', ' Sans conservateurs'),
('6', ' Sans huile de palme'),
('7', ' Tidyman wastebasket'),
('8', ' IGP'),
('9', ' Nourri sans OGM');

--
-- Déchargement des données de la table `LIEU`
--

INSERT INTO `LIEU` (`LIEU_ID`, `LIEU_LIBELLE`) VALUES
(1, ' CEE'),
(2, ' France'),
(3, ' Sarthe'),
(4, ' Normandie'),
(5, ' Italie'),
(6, ' Ireland');

--
-- Déchargement des données de la table `MAGASIN`
--

INSERT INTO `MAGASIN` (`MAG_CODE`, `MAG_LIBELLE`) VALUES
('1', ' Magasins U'),
('2', ' Carrefour'),
('3', ' Leclerc'),
('4', ' Franprix'),
('5', ' Auchan'),
('6', ' McDonald''s'),
('7', ' Super U'),
('8', ' Intermarché');

--
-- Déchargement des données de la table `MARQUE`
--

INSERT INTO `MARQUE` (`MAR_CODE`, `MAR_LIBELLE`) VALUES
('1', ' Fabriquée à La Ferme Du Gaec Muris'),
('10', ' Oiseaux Celestes'),
('11', ' Barilla'),
('12', ' La Collezione d''Italia'),
('13', ' Cristaline'),
('14', ' Cauvin'),
('15', ' McDonald''s'),
('16', ' Fleury Michon'),
('2', 'Terroir de la Sée'),
('3', ' Ferrero'),
('4', ' Nutella'),
('5', ' Vico'),
('6', ' Intersnack France'),
('7', ' Sodebo'),
('8', ' Loué'),
('9', ' Jort');

--
-- Déchargement des données de la table `NOVA`
--

INSERT INTO `NOVA` (`NOVA_ID`, `NOVA_LIBELLE`) VALUES
(1, 'Aliments non transformés'),
(2, 'Ingrédients culinaires transformés'),
(3, 'Aliments transformés'),
(4, 'Produits alimentaires / boissons ultra-transformés');

--
-- Déchargement des données de la table `NUTRISCORE`
--

INSERT INTO `NUTRISCORE` (`NUT_CODE`, `NUT_LIBELLE`) VALUES
('A', 'A'),
('B', 'B'),
('C', 'C'),
('D', 'D'),
('E', 'E');

--
-- Déchargement des données de la table `PAYS`
--

INSERT INTO `PAYS` (`PAY_CODE`, `PAY_LIBELLE`) VALUES
('1', ' France'),
('2', ' Suisse'),
('3', ' Belgique'),
('4', ' Italie'),
('5', ' Luxembourg'),
('6', ' Mali'),
('7', ' Martinique'),
('8', ' Irlande'),
('9', ' Espagne');

--
-- Déchargement des données de la table `PRODUIT`
--

INSERT INTO `PRODUIT` (`PRO_ID`, `COD_ID`, `NOVA_ID`, `NUT_CODE`, `PRO_LIBELLE`, `PRO_INGREDIENT`, `PRO_LIEN`, `PRO_QUANTITE`, `PRO_ENERGIE`, `PRO_MATIEREGRASSE`, `PRO_ACIDEGRAS`, `PRO_GLUCIDE`, `PRO_SUCRE`, `PRO_FIBRE`, `PRO_PROTEINE`, `PRO_SEL`, `PRO_SODIUM`) VALUES
(1, NULL, 1, 'B', 'Teurgoule de la Sée', NULL, 'https://fr.openfoodfacts.org/produit/3488790000214/teurgoule-de-la-see-fabriquee-a-la-ferme-du-gaec-muris', 440, 122, '3.500', '2.30', '18.30', '0.00', '0.00', '3.90', '0.04', '0.02'),
(2, NULL, 4, 'E', 'Nutella', 'Sucre, huile de palme, noisettes 13%, cacao maigre 7,4%, lait écrémé en poudre 6,6%, lactoserum en poudre, émulsifiants : lécithines [soja], vanilline.', 'https://fr.openfoodfacts.org/produit/3017620421006/nutella-ferrero', 750, 544, '31.600', '11.00', '57.60', '56.80', '0.00', '6.30', '0.11', '0.04'),
(3, NULL, 3, 'D', 'La classique nature', 'Pommes de terre, huile de tournesol, sel', 'https://fr.openfoodfacts.org/produit/3336971209164/la-classique-nature-135-g-vico', 135, 525, '34.000', '2.80', '46.70', '0.60', '0.00', '5.90', '1.30', '0.51'),
(4, NULL, 4, 'C', 'Dolce Pizza Regina', 'Garniture 60 % : mozzarella en copeaux 28 %, sauce tomate 27 % (purée de tomate, eau, farine de blé, sel), chiffonnade de jambon cuit 22 % (jambon de porc, eau, sel, dextrose, sirop de glucose, stabilisant : E451, arômes naturels (dont gluten), gélifiant ', 'https://fr.openfoodfacts.org/produit/3242272340850/dolce-pizza-regina-sodebo', 380, 181, '4.600', '2.90', '22.20', '2.10', '0.00', '10.90', '1.46', '0.58'),
(5, 1, 1, 'B', 'Poulet Fermier Label Rouge de Loué', 'Poulet fermier 100%', 'https://fr.openfoodfacts.org/produit/0217013081678/poulet-fermier-label-rouge-de-loue', 1448, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(6, 2, 3, 'D', 'Camembert de Normandie', 'lait cru', 'https://fr.openfoodfacts.org/produit/3023260028437/camembert-de-normandie-22-mg-jort', 250, 277, '21.000', '15.50', '0.00', '0.00', NULL, '20.00', '1.55', '0.61'),
(7, NULL, 1, 'A', 'Riz Jasmin Extra Parfumé', 'Riz Thaï', 'https://fr.openfoodfacts.org/produit/3364699010434/riz-jasmin-extra-parfume-oiseaux-celestes', 1000, 338, '0.900', '0.40', '76.00', '0.00', '2.90', '6.60', '0.00', '0.00'),
(8, NULL, 3, 'A', 'Tagliatelles', '\r\nSemoule de blé dur, œufs (19,36 %).', 'https://fr.openfoodfacts.org/produit/8076808201293/tagliatelles-barilla', 500, 373, '4.000', '1.00', '66.00', '3.00', '4.00', '14.00', '0.00', '0.00'),
(9, 3, 1, 'A', 'Eau de source Cristaline', 'Eau de source.', 'https://fr.openfoodfacts.org/produit/3274080005003/eau-de-source-24-cristaline', 150, NULL, '0.000', '0.00', '0.00', '0.00', '0.00', '0.00', '0.03', '0.01'),
(10, NULL, 2, 'D', 'Huile d''olive bio Fruitée vert Cauvin', 'D''huiles Biologiques à déguster sans rn5dération. HUILE D''OLIVE VIERGE EXTRA BIO', 'https://fr.openfoodfacts.org/produit/3336590083787/huile-d-olive-bio-fruitee-vert-cauvin', 75, 900, '100.000', '17.00', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00'),
(11, NULL, 3, 'C', 'Big Mac', 'Pain spécial, steaks hachés, salade, oignon, cornichon, fromage fondu, sauce, (selon le site) En quantités inconnues : Anhydride sulfureux et sulfites, Gluten (blé), Graine de sésame, Lait, Oeufs, Moutarde.', 'https://fr.openfoodfacts.org/produit/2000000002603/big-mac-mcdonald-s', 220, 230, '12.000', '4.50', '19.00', '3.90', '1.40', '12.00', '1.00', '0.39'),
(12, NULL, 4, 'C', 'Le supérieur cuit à l''étouffée', 'Le supérieur cuit à l''étouffée', 'https://fr.openfoodfacts.org/produit/3095756214013/le-superieur-cuit-a-l-etouffee-6tr-fleury-michon', 240, 117, '2.800', '1.00', '0.70', '0.70', '0.50', '22.00', '1.80', '0.71');

--
-- Déchargement des données de la table `STOCKER`
--

INSERT INTO `STOCKER` (`CON_CODE`, `PRO_ID`) VALUES
('1', 2),
('2', 2),
('3', 2);

--
-- Déchargement des données de la table `VENDRE`
--

INSERT INTO `VENDRE` (`PRO_ID`, `PAY_CODE`) VALUES
(1, '1'),
(2, '1'),
(2, '2');


--
-- Déchargement des données de la table `APPARTENIR`
--

INSERT INTO `APPARTENIR` (`CAT_CODE`, `PRO_ID`) VALUES
('1', 1),
('10', 2),
('11', 2),
('2', 1),
('3', 1),
('4', 1),
('5', 2),
('6', 2),
('7', 2),
('8', 2),
('9', 2);

--
-- Déchargement des données de la table `CERTIFIER`
--

INSERT INTO `CERTIFIER` (`PRO_ID`, `LAB_CODE`) VALUES
(2, '1'),
(2, '10');

--
-- Déchargement des données de la table `COMMERCIALISER`
--

INSERT INTO `COMMERCIALISER` (`MAG_CODE`, `PRO_ID`) VALUES
('1', 1),
('1', 2),
('2', 2);

--
-- Déchargement des données de la table `CONSTITUER`
--

INSERT INTO `CONSTITUER` (`ALL_CODE`, `PRO_ID`) VALUES
('1', 1),
('1', 2),
('2', 2),
('3', 2);

--
-- Déchargement des données de la table `CONTENIR`
--

INSERT INTO `CONTENIR` (`PRO_ID`, `ADD_ID`) VALUES
(2, 1);

--
-- Déchargement des données de la table `ETRE`
--

INSERT INTO `ETRE` (`PRO_ID`, `MAR_CODE`) VALUES
(1, '1'),
(1, '2'),
(2, '3'),
(2, '4');

--
-- Déchargement des données de la table `FABRIQUER`
--

INSERT INTO `FABRIQUER` (`PRO_ID`, `LIEU_ID`) VALUES
(2, 1);

