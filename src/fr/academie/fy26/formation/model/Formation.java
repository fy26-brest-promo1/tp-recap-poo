package fr.academie.fy26.formation.model;

import fr.academie.fy26.formation.exception.CapaciteFormationAtteinteException;
import fr.academie.fy26.formation.exception.DejaInscritException;
import fr.academie.fy26.formation.exception.DonneeInvalideException;
import fr.academie.fy26.formation.exception.EntityNonTrouveeException;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente une formation.
 * Règles : max 10 stagiaires, durée > 0, pas d'inscription double.
 */
public class Formation {
    private String code;
    private String intitule;
    private int dureeJours;
    private Formateur formateur;
    private List<Stagiaire> stagiaires;

    public static final int MAX_STAGIAIRES = 10;

    /**
     * Constructeur Formation
     * @param code code unique
     * @param intitule intitulé
     * @param dureeJours durée en jours (>0)
     * @param formateur formateur responsable
     * @throws DonneeInvalideException si durée <= 0
     */
    public Formation(String code, String intitule, int dureeJours, Formateur formateur) {
        if (dureeJours <= 0)
            throw new DonneeInvalideException("Durée > 0");
        this.code = code;
        this.intitule = intitule;
        this.dureeJours = dureeJours;
        this.formateur = formateur;
        this.stagiaires = new ArrayList<>();
    }

    public String getCode() { return code; }
    public String getIntitule() { return intitule; }
    public int getDureeJours() { return dureeJours; }
    public Formateur getFormateur() { return formateur; }
    public List<Stagiaire> getStagiaires() { return stagiaires; }

    /**
     * Ajoute un stagiaire à la formation.
     * @param s stagiaire à ajouter
     * @throws CapaciteFormationAtteinteException si capacité atteinte ou déjà inscrit
     */
    public void ajouterStagiaire(Stagiaire s) {
        if (stagiaires.size() >= MAX_STAGIAIRES)
            throw new CapaciteFormationAtteinteException("Capacité formation atteinte");
        if (stagiaires.contains(s))
            throw new DejaInscritException("Déjà inscrit");
        stagiaires.add(s);
    }

    /**
     * Retire un stagiaire de la formation.
     * @param s stagiaire à retirer
     * @throws EntityNonTrouveeException si stagiaire non inscrit
     */
    public void retirerStagiaire(Stagiaire s) {
        if (!stagiaires.contains(s))
            throw new EntityNonTrouveeException("Stagiaire non inscrit");
        stagiaires.remove(s);
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%d jours, %s) - %d stagiaire(s) inscrit(s)", code, intitule, dureeJours, formateur.getNom(), stagiaires.size());
    }
}
