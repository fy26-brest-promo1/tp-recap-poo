package fr.academie.fy26.formation.model;

import fr.academie.fy26.formation.exception.DonneeInvalideException;

/**
 * Représente un formateur du centre.
 * Règle : capacité max strictement positive.
 */
public class Formateur extends Personne {
    private String specialite;
    private int capaciteMaxStagiaires;

    /**
     * Constructeur Formateur
     * @param id identifiant
     * @param nom nom
     * @param prenom prénom
     * @param specialite spécialité
     * @param capaciteMaxStagiaires capacité maximale (>0)
     * @throws DonneeInvalideException si capacité <= 0
     */
    public Formateur(int id, String nom, String prenom, String specialite, int capaciteMaxStagiaires) {
        super(id, nom, prenom);
        if (capaciteMaxStagiaires <= 0)
            throw new DonneeInvalideException("Capacité max > 0");
        this.specialite = specialite;
        this.capaciteMaxStagiaires = capaciteMaxStagiaires;
    }

    public String getSpecialite() { return specialite; }
    public int getCapaciteMaxStagiaires() { return capaciteMaxStagiaires; }

    @Override
    /** Retourne le rôle de la personne (formateur).
     */
    public String getRole() { return "Formateur"; }
}
