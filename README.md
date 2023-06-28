# Projet Aventurier

Ce projet est une application Web pour gérer les déplacements d'un aventurier sur une carte.

## Installation

### Prérequis

- Java 17
- Node.js
- Maven
- Angular

### Backend

1. Clonez ce dépôt Git :

   ```shell
   git clone https://github.com/Salahlemangar/aventurier.git

2. Accédez au répertoire du projet backend :

   ```shell 
   cd aventurier/backend

3. Compilez et exécutez le backend avec Maven :

   ```shell
   mvn spring-boot:run
   
Le backend sera lancé et sera accessible à l'URL http://localhost:8080.

## Tests

Le projet comprend des tests unitaires pour le backend.


Les tests unitaires du backend sont écrits en utilisant le framework de test JUnit.

Pour exécuter les tests du backend, suivez les étapes suivantes :

1.	Accédez au répertoire du projet backend :

    ```shell
    cd aventurier/backend


2.	Exécutez la commande suivante pour exécuter les tests :

    ```shell
    mvn test

Les tests seront exécutés et les résultats seront affichés dans la console.

## Test de l’API /move avec Postman

L’API /move permet de déplacer le personnage en fonction des coordonnées initiales et des mouvements spécifiés.

Suivez les étapes ci-dessous pour tester cette API à l’aide de l’outil Postman :

1.	Assurez-vous que le serveur backend est en cours d’exécution.
2.	Lancez Postman.
3.	Sélectionnez la méthode HTTP “POST” dans Postman.
4.	Entrez l’URL de l’API complète dans la barre d’URL :

    ```shell
    http://localhost:8080/api/character/move

5.	Dans l’onglet “Body” de Postman, sélectionnez “raw” et choisissez le format “JSON (application/json)”.
6.	Dans le corps de la requête, spécifiez les paramètres suivants :

    ```shell
    {
      "initialCoordinates": {
      "x": 3,
      "y": 0
    },
    "movements": "SSSSEEEEEENN"
    }

6.	Assurez-vous d’ajuster les coordonnées initiales et les mouvements selon vos besoins.
7.	Cliquez sur le bouton “Send” pour envoyer la requête à l’API.
8.	Vous recevrez une réponse de l’API contenant les nouvelles coordonnées du personnage déplacé.

Exemple de réponse :

     {
       "x": 6,
       "y": 4
     }

8.	Les coordonnées x et y représentent la position finale du personnage après les mouvements spécifiés.

Ceci conclut le test de l’API /move avec Postman. Vous pouvez effectuer plusieurs tests en modifiant les coordonnées initiales et les mouvements pour observer les résultats correspondants.

N’oubliez pas de vous assurer que le serveur backend est en cours d’exécution avant de tester l’API avec Postman.

### Frontend

1. Accédez au répertoire du projet frontend :

   ```shell
   cd aventurier/aventurierfrontend
   
2. Installez les dépendances Node.js :

   ```shell
   npm install
   
3. Lancez le serveur de développement :

   ```shell
   npm run serve

   
Le frontend sera lancé et sera accessible à l'URL http://localhost:4200.

### Configuration Backend

1. Ouvrez le fichier backend/src/main/resources/application.properties.
2. Vérifiez et modifiez si nécessaire les propriétés de configuration.

### Frontend

1. Ouvrez un navigateur Web et accédez à l'URL http://localhost:4200.
2. Utilisez le formulaire pour saisir les coordonnées initiales et les mouvements de l'aventurier.
3. Cliquez sur le bouton "Déplacer" pour obtenir les nouvelles coordonnées de l'aventurier.

Le résultat sera affiché à l'écran.





