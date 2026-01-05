# TP Java POO — Centre de formation

## Objectif

Mini-application Java console de gestion d’un centre de formation, mobilisant les notions clés de la POO : héritage, abstraction, interfaces, collections, tri, exceptions personnalisées, packages, String, static, généricité, Javadoc.

---

## Contraintes générales
- Java standard (pas de framework)
- Application console (pas d’UI graphique)
- Code orienté objet, propre et lisible
- Pas de logique métier dans le main
- Organisation en packages
- Utilisation de Collections et de tris
- Gestion des erreurs avec exceptions personnalisées
- Javadoc obligatoire sur les classes principales

---

## Organisation des packages
- `fr.academie.fy26.formation.model`
- `fr.academie.fy26.formation.service`
- `fr.academie.fy26.formation.exception`
- `fr.academie.fy26.formation.util`
- `fr.academie.fy26.formation.main`

---

## Modèle de domaine (`fr.academie.fy26.formation.model`)

### 1. Personnes
- **Personne** (abstraite)
  - Attributs : `id`, `nom`, `prenom`
  - Méthodes : constructeur, getters, méthode abstraite `getRole()`
  - Contraintes : nom et prénom obligatoires (sinon exception)
- **Stagiaire** (hérite de Personne)
  - Attributs : `niveau`, collection des formations suivies
  - Méthodes : constructeur, getters, implémentation de `getRole()`
- **Formateur** (hérite de Personne)
  - Attributs : `specialite`, `capaciteMaxStagiaires` (>0)
  - Méthodes : constructeur, getters, implémentation de `getRole()`

### 2. Formation
- Attributs : `code`, `intitule`, `dureeJours` (>0), `formateur`, collection de stagiaires inscrits (max 10)
- Contraintes : pas d’inscription double, durée > 0

---

## Exceptions personnalisées (`fr.academie.fy26.formation.exception`)
- Au moins 3 exceptions :
  - `CapaciteFormationAtteinteException`
  - `DejaInscritException`
  - `DonneeInvalideException` (ou `ValidationException`)
  - (optionnel) `EntityNotFoundException`
- Les exceptions doivent être utilisées réellement dans le code

---

## Service d’inscription (`fr.academie.fy26.formation.service`)
- Interface : `InscriptionService` avec :
  - `void inscrire(Stagiaire stagiaire, Formation formation);`
  - `void desinscrire(Stagiaire stagiaire, Formation formation);`
- Implémentation : `InscriptionServiceImpl` qui applique toutes les règles métier (refus si formation pleine, déjà inscrit, etc.)

---

## Centre de formation (`fr.academie.fy26.formation.model`)
- Classe `CentreFormation` centralisant :
  - Collection de toutes les formations
  - Collection de tous les stagiaires
  - (Optionnel) collection de formateurs
- Fonctionnalités :
  1. Ajouter une formation
  2. Ajouter un stagiaire
  3. Rechercher une formation par code (exception si introuvable)
  4. Afficher tous les stagiaires triés par nom
  5. Afficher toutes les formations triées par durée
  6. Afficher les stagiaires d’une formation donnée
- Utilisation de `Comparator`, `Collections.sort()` ou `stream().sorted()` pour les tris

---

## Généricité (`fr.academie.fy26.formation.util`)
- Classe générique : `Afficheur<T>`
  - Méthode : `void afficher(List<T> elements)`
  - Fonctionne avec : `List<Stagiaire>`, `List<Formation>`, `List<Personne>`

---

## Static + Strings (code formation) (`fr.academie.fy26.formation.util`)
- Générateur de code formation : `CodeFormationGenerator`
  - Format attendu : `JAVA-2026-001`, `JAVA-2026-002`, ...
  - Utilise au moins un `static` et manipule des `String` (concaténation, format, padding)

---

## Javadoc
- Obligatoire sur :
  - `Personne`, `Stagiaire`, `Formateur`, `Formation`, `CentreFormation`, `InscriptionService`
- Doit expliquer : rôle de la classe, règles importantes, paramètres et exceptions des méthodes critiques

---

## Démonstration (`fr.academie.fy26.formation.main`)
- Classe `MainApp` avec une méthode `main` qui :
  1. Crée un centre de formation
  2. Crée 2 formateurs
  3. Crée 3 formations
  4. Crée 6 stagiaires
  5. Effectue plusieurs inscriptions
  6. Affiche :
     - Stagiaires triés par nom
     - Formations triées par durée
     - Stagiaires d’une formation donnée
  7. Déclenche volontairement au moins une exception (et l’affiche proprement)
- Le main doit rester lisible : pas de gros blocs de logique métier, seulement des appels à vos classes/services

---

## Bonus
- enum Niveau { DEBUTANT, INTERMEDIAIRE, AVANCE }
- override toString() sur vos entités
- override equals() / hashCode() (ex : sur id ou sur code)
- ajouter une méthode de statistiques (ex : nb stagiaires par formation)
- utilisation de Map pour indexer les formations par code

---

## Auteur
- Emmanuel Fernandez

