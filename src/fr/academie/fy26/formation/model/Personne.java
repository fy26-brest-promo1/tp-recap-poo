package fr.academie.fy26.formation.model;

import fr.academie.fy26.formation.exception.DonneeInvalideException;

/**
 * Classe abstraite représentant une personne du centre de formation.
 * Règle : nom et prénom ne doivent pas être vides.
 */
public abstract class Personne {
    protected int id;
    protected String nom;
    protected String prenom;

    /**
     * Constructeur de la classe Personne.
     * @param id identifiant unique
     * @param nom nom de la personne (non vide)
     * @param prenom prénom de la personne (non vide)
     * @throws DonneeInvalideException si nom ou prénom vide
     */
    public Personne(int id, String nom, String prenom) {
        if (nom == null || nom.isBlank() || prenom == null || prenom.isBlank())
            throw new DonneeInvalideException("Nom et prénom obligatoires");
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }

    /**
     * Retourne le rôle de la personne (stagiaire ou formateur).
     */
    public abstract String getRole();

    @Override
    public String toString() {
        return String.format("%s %s (%s)", prenom, nom, getRole());
    }
}
