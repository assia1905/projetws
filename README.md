# Projet de Gestion des Étudiants

## Description
Ce projet est une application Android qui permet de gérer des informations d'étudiants. L'application offre des fonctionnalités pour ajouter, modifier, supprimer et afficher des étudiants. Les données sont échangées avec un serveur PHP à l'aide d'API REST.

## Fonctionnalités
- **Ajout d'Étudiant** : Permet d'ajouter de nouveaux étudiants avec des informations telles que le nom, le prénom, la ville et le sexe.
- **Affichage des Étudiants** : Affiche la liste des étudiants dans une `RecyclerView`.
- **Modification d'Étudiant** : Permet de modifier les informations des étudiants existants.
- **Suppression d'Étudiant** : Permet de supprimer des étudiants de la liste.
- **Filtrage** : Permet de filtrer la liste des étudiants en fonction de critères spécifiques.
- **Événements de Balayage** : Utilise des événements de balayage pour supprimer des étudiants de la liste.

## Technologies Utilisées
- **Android Studio** : IDE pour le développement d'applications Android.
- **Java** : Langage de programmation utilisé pour développer l'application Android.
- **Volley** : Bibliothèque utilisée pour effectuer des requêtes HTTP.
- **PHP** : Langage de script côté serveur utilisé pour créer des API.
- **MySQL** : Système de gestion de bases de données pour stocker les informations des étudiants.

## Installation
1. Clonez le repository :
   ```bash
   git clone https://github.com/votre-utilisateur/votre-repo.git
2.Ouvrez le projet dans Android Studio.
3.Modifiez l'URL de l'API dans la classe AddEtudiant.java pour qu'elle corresponde à votre serveur local :
 - private String insertUrl = "http://192.168.1.151:8080/PhpProject1/ws/createEtudiant.php";
4.Assurez-vous que votre serveur PHP est en cours d'exécution sur le port 8080.
5.Exécutez l'application sur votre appareil Android ou un émulateur.
## Utilisation
- Ouvrez l'application sur votre appareil.
- Remplissez les champs pour ajouter un étudiant.
- Cliquez sur le bouton "Ajouter" pour soumettre les informations.
- La liste des étudiants sera affichée dans la RecyclerView.
## Video demonstratif 
- ![Capture d'écran 2024-10-22 233551](https://github.com/user-attachments/assets/8388ac80-35b5-4c86-a0af-95ee8f7ae535)
- https://github.com/user-attachments/assets/21222900-d65f-4bf9-96ec-43e8351e5ebf
- ![Capture d'écran 2024-10-22 233851](https://github.com/user-attachments/assets/e258fe35-f3b9-4a2e-bc98-73359cf6943f)
## Auteur
- Assia BOUJNAH
