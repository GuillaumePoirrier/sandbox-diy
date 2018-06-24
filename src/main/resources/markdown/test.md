## Introduction

Transforme le dictionnaire de données json-schéma en fichier excel.

## Architecture

Projet Maven avec Java 1.8

## Librairies utilisées

* Jackson
* Apache POI

## Exécution
### 1ere solution : Placer le fichier .jar avec le fichier json

    java -jar json-2-xls-jar-with-dependencies.jar *chemin\du\dossier_contenant_les_json*
    
Le fichier créé sera *Dictionnaire_de_donnees.xlsx* par défaut, on peut changer dans XLSXBuilder

### 2eme solution :  Exécuter le fichier bin/JsonToXLSX.bat

Parametrer le .bat en éditant bin/conf.cmd avec Notepad++ si besoin 

## Résultat

Selon deux onglets, "entities" et "définitons", avec pour chacun :

| Catégorie    | Parent        | Titre        | Description  | Définition  | Chemin  |Chemin de la référence  |
| --------- |:-------------:| :-----------:| :-----------:| -----------:|--------:|-----------------------:|

## La colonne 'Definition'

Cette colonne indique soit le type d'objet s'il s'agit d'un objet simple, et un lien vers l'objet complexe sinon.

### Type d'objet simple

| Tables        | Are           | Cool  |
| ------------- |:-------------:| -----:|
| col 3 is      | right-aligned | $1600 |
| col 2 is      | centered      |   $12 |
| zebra stripes | are neat      |    $1 |


### Lien vers un objet complexe

Le lien est généré par une formule Excel insérée directement en Java avec la librairie Apache POI et la méthode setCellFormula()  :

    =LIEN_HYPERTEXTE(CONCATENER("[.\]definitions!C";EQUIV("CHEMIN_A_TROUVER_DANS_DEFINITIONS;definitions!F:F;0));"TEXTE_DU_LIEN")
    
## Test unitaire

A l'heure actuelle, seul le test unitaire de création des listes d''Element' correspondant à chaque page est rédigé.

* jsonExplorerTestCase()
    
    
