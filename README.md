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





