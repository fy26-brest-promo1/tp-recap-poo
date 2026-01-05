package fr.academie.fy26.formation.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente un stagiaire inscrit à des formations.
 */
public class Stagiaire extends Personne {
    private String niveau;
    private List<Formation> formations;

    /**
     * Constructeur Stagiaire
     * @param id identifiant
     * @param nom nom
     * @param prenom prénom
     * @param niveau niveau du stagiaire
     */
    public Stagiaire(int id, String nom, String prenom, String niveau) {
        super(id, nom, prenom);
        this.niveau = niveau;
        this.formations = new ArrayList<>();
    }

    public String getNiveau() { return niveau; }
    public List<Formation> getFormations() { return formations; }

    @Override
    /** Retourne le rôle de la personne (stagiaire).
     */
    public String getRole() { return "Stagiaire"; }
}
