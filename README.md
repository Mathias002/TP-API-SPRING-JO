
Mousset Mathias

# ✨ TP-API-SPRING-JO ✨

L'objectif de ce projet était de mettre en place et de pouvoir gérer une billetterie pour les jeux Olympiques, cette billetterie devait comporter certaines contraintes que voici : 

- On peut acheter un billet pour une épreuve, seulement si on n'est pas inscrit à une épreuve à la même date.
- Il faut au moins un CRUD pour 4 ressources différentes.
- Les différents rôles des utilisateurs doivent être gérés.
- Le projet doit bien être architecturé (Service, Controller, Repository, DTO etc...)
- On peut acheter un billet soit pour soi-même, soit pour un groupe de personnes
- Il faut une certaine logique métier (validation, vérification des possibilités de réservation etc...)
- Les erreurs doivent être gérées
- Il faut des relations entre les entités
- Le rendu doit être fait via git
- Un joli README serait un plus pour savoir quelles routes appeler pour tester les requêtes (documentation swagger possible)
- La connexion doit être sécurisée

Compte tenu des délais, des obligations vis-à-vis de mon diplôme, ainsi que des explications de notre professeur concernant le barème, mon projet ne comporte pas autant de fonctionnalité et se contentera d'embarquer le minimum.

A savoir :

- La possibilité de s'inscrire 
- La possibilité de se connecter de manière sécurisée avec un Rôle 
- La présence de six CRUD (Spectateur / Stade / Commande / Boutique / Epreuve / Billet)

Chemin d'accès au fichier de lancement de l'API :

    - /test/src/main/java/fr/efrei/test/TestApplication.java

Accès au MCD de mon API :

    - /MCD-API-SPRING.lo1

 ⚠️ Il est important de préciser qu'il est nécessaire de faire attention de bien configurer le port d'écoute, mon projet est configuré pour le port 8080. De plus il faut au préalable avoir crée une base de donnée portant le même nom que celle inscrite dans le fichier de configuration "application.properties" par défaut "tp-api-spring" ⚠️

## 📝 INSCRIPTION 📝

    L'utilisateur pourra s'inscrire via la route suivante : "localhost:8080/auth/signup" 

    Il lui sera demandé de renseigner son email, mot de passe, nom et prénom.

    Contraintes : 🔒
    - Mot de passe => minimum 9 caractères, minuscule, minimum une majuscule, minimum un chiffre, minimum un caractère spécial.
    - Aucuns champs ne peut être vide
    - Le nom et prénom doivent comporter au minimum deux caractères

    Exemple :
    {
        "email": "poipoi.fr@gmail.com",
        "password": "Test1234!",
        "nom": "Poipoi",
        "prenom": "Tom"
    }

    L'utilisateur possède maintenant le Rôle USER et peut se connecter.

## CONNEXION

    Un utilisateur possédant un compte peut se connecter via la route suivante : 
    localhost:8080/auth/login

    Afin de se connecter, il devra renseigner son email ainsi que son mot de passe.

    Contrainte : 🔒
    - Aucuns champs ne peut être vide

    Exemple : 
    {
        "email": "poipoi.fr@gmail.com",
        "password": "Test1234!"
    }

    Si les données renseigner son juste, l'utilisateur sera authentifié via un token et pourra effectuer des actions au sein de l'API.

## CRUD 

### 👨‍👩‍👧‍👦 Spectateur 👨‍👩‍👧‍👦

    - Ajout ✅
    
        L'ajout d'un spectateur correspond à la création d'un compte, se référer à la partie concernée.

    - Affichage 🔍

        La consultation s'effectue via la route : localhost:8080/spectateurs/{spectateur_uuid} avec comme requête "GET"

    - Modification (totale / partielle) 🛠️

        La modification s'effectue via la route : localhost:8080/spectateurs/{spectateur_uuid},
        avec comme requête "PUT" pour une mise à jour totale ou bien "PATCH" pour une mise à jour partielle

        Contraintes : 🔒
        Les contraintes sont les mêmes que pour l'ajout

    - Suppression ❌

        La suppression s'effectue via la route : localhost:8080/spectateurs/{spectateur_uuid} avec comme requête "DELETE"


### 🏪 Boutique 🏪

    - Ajout ✅

        L'ajout d'une boutique ne nécessite qu'un nom 

        Contraintes : 🔒
        - le champ nomBoutique ne peut pas être vide 
        - Le nom de la boutique doit contenir 2 caractères minimum

        Exemple : 
        {
            "nomBoutique": "Boutique Football"
        }

    - Affichage 🔍

        La consultation s'effectue via la route : localhost:8080/boutiques/{boutique_uuid} avec comme requête "GET"

    - Modification (totale / partielle) 🛠️

        La modification s'effectue via la route : localhost:8080/boutiques/{boutique_uuid},
        avec comme requête "PUT" pour une mise à jour totale ou bien "PATCH" pour une mise à jour partielle

        Contraintes : 🔒
        Les contraintes sont les mêmes que pour l'ajout

    - Suppression ❌

        La suppression s'effectue via la route : localhost:8080/boutiques/{boutique_uuid} avec comme requête "DELETE"

### 🏟️ Stade 🏟️

    - Ajout ✅

        L'ajout d'un stade nécessite un nom, une adresse, ainsi qu'une capacité d'accueil

        Contraintes : 🔒
        - les champs nomStade, adresseStade, et capaciteStade  ne peuvent pas être vide/null
        - Le nom du stade doit contenir 2 caractères minimum
        - La capacité du stade doit être égal ou supérieur à 10 000

        Exemple : 
        {
            "nomStade": "Stade de France",
            "adresseStade": "La Plaine ZAC du Cornillon Nord 93216 Saint-Denis",
            "capaciteStade": 80698
        }

    - Affichage 🔍

        La consultation s'effectue via la route : localhost:8080/stades/{stade_uuid} avec comme requête "GET"

    - Modification (totale / partielle) 🛠️

        La modification s'effectue via la route : localhost:8080/stades/{stade_uuid},
        avec comme requête "PUT" pour une mise à jour totale ou bien "PATCH" pour une mise à jour partielle

        Contraintes : 🔒
        Les contraintes sont les mêmes que pour l'ajout

    - Suppression ❌

        La suppression s'effectue via la route : localhost:8080/stades/{stade_uuid} avec comme requête "DELETE"

### 🏆 Epreuve 🏆

    - Ajout ✅

        L'ajout d'une epreuve nécessite un libelle, une description, une date, son état (ouverte ou non), ainsi que le ou les stades ou elle se déroulera 

        Contraintes : 🔒
        - les champs libelleEpreuve, descriptionEpreuve, dateEpreuve ne peuvent pas être vide 
        - Le libelle et la description de l'épreuve doivent contenir 2 caractères minimum

        Exemple : 
        {
            "libelleEpreuve": "Football",
            "descriptionEpreuve": "Compétition de football",
            "dateEpreuve": "2024-06-01T10:00:00",
            "estOuverte": true,
            "stadeUuids": [
                "{stade_uuid}",
                "{stade_uuid}"
            ]
        }

    - Affichage 🔍

        La consultation s'effectue via la route : localhost:8080/epreuves/{epreuve_uuid} avec comme requête "GET"

    - Modification (totale / partielle) 🛠️

        La modification s'effectue via la route : localhost:8080/epreuves/{epreuve_uuid},
        avec comme requête "PUT" pour une mise à jour totale ou bien "PATCH" pour une mise à jour partielle

        Contraintes : 🔒
        Les contraintes sont les mêmes que pour l'ajout

    - Suppression ❌

        La suppression s'effectue via la route : localhost:8080/epreuves/{epreuve_uuid} avec comme requête "DELETE"

### 🛍️ Commande 🛍️

    - Ajout ✅

        L'ajout d'une commande nécessite un nom, ainsi qu'un spectateur

        Contraintes : 🔒
        - les champs nom, et spectateur ne peuvent pas être vide 
        - Le nom de la commande doit contenir 2 caractères minimum

        Exemple :
        {
            "nom": "Commande football France - Allemagne",
            "spectateur": "{spectateur_uuid}"
        }

    - Affichage 🔍

        La consultation s'effectue via la route : localhost:8080/commandes/{commande_uuid} avec comme requête "GET"

    - Modification (totale / partielle) 🛠️

        La modification s'effectue via la route : localhost:8080/commandes/{commande_uuid},
        avec comme requête "PUT" pour une mise à jour totale ou bien "PATCH" pour une mise à jour partielle

        Contraintes : 🔒
        Les contraintes sont les mêmes que pour l'ajout

    - Suppression ❌

        La suppression s'effectue via la route : localhost:8080/commandes/{commande_uuid} avec comme requête "DELETE"

### 🎫 Billet 🎫

    - Ajout ✅

        L'ajout d'un billet nécessite un nom, un prix, une boutique, une commande ainsi qu'une épreuve 

        Contraintes : 🔒
        - les champs nom, prix, boutique, commande, et epreuve ne peuvent pas être vide 
        - Le nom de la commande doit contenir 2 caractères minimum

        Exemple :
        {
            "nom":"Billet football France - Allemagne",
            "prix":45.5,
            "boutique":"{boutique_uuid}",
            "commande":"{commande_uuid}",
            "epreuve":"{epreuve_uuid}"
        }

    - Affichage 🔍

        La consultation s'effectue via la route : localhost:8080/billets/{billet_uuid} avec comme requête "GET"

    - Modification (totale / partielle) 🛠️

        La modification s'effectue via la route : localhost:8080/billets/{billet_uuid},
        avec comme requête "PUT" pour une mise à jour totale ou bien "PATCH" pour une mise à jour partielle

        Contraintes : 🔒
        Les contraintes sont les mêmes que pour l'ajout

    - Suppression ❌

        La suppression s'effectue via la route : localhost:8080/billets/{billet_uuid} avec comme requête "DELETE"

## 🏁 CONCLUSION 🏁

    Voilà tout concernant ce projet de billetterie, il est loin d'être complet et parfait, mais il embarque (normalement) le minimum requis. Merci d'avoir pris le temps de lire cette explication de mon projet, et si vous avez eu le courage de le lire jusqu'au bout, je vous souhaite bon courage pour les corrections :) 





