package fr.academie.fy26.formation.model;

import fr.academie.fy26.formation.exception.DonneeInvalideException;
import fr.academie.fy26.formation.exception.EntityNonTrouveeException;
import java.util.*;

/**
 * Centre de formation : centralise stagiaires, formateurs, formations.
 */
public class CentreFormation {
    private List<Formation> formations = new ArrayList<>();
    private List<Stagiaire> stagiaires = new ArrayList<>();
    private List<Formateur> formateurs = new ArrayList<>();

    /**
     * Ajoute une formation au centre.
     * @param f formation à ajouter
     * @throws DonneeInvalideException si formation nulle ou déjà existante
     */
    public void ajouterFormation(Formation f) {
        if (f == null || formations.contains(f))
            throw new DonneeInvalideException("Formation invalide ou déjà existante");
        formations.add(f);
    }

    /**
     * Ajoute un stagiaire au centre.
     * @param s stagiaire à ajouter
     * @throws DonneeInvalideException si stagiaire nul ou déjà existant
     */
    public void ajouterStagiaire(Stagiaire s) {
        if (s == null || stagiaires.contains(s))
            throw new DonneeInvalideException("Stagiaire invalide ou déjà existant");
        stagiaires.add(s);
    }

    /**
     * Ajoute un formateur au centre.
     * @param f formateur à ajouter
     * @throws DonneeInvalideException si formateur nul ou déjà existant
     */
    public void ajouterFormateur(Formateur f) {
        if (f == null || formateurs.contains(f))
            throw new DonneeInvalideException("Formateur invalide ou déjà existant");
        formateurs.add(f);
    }

    /**
     * Recherche une formation par code.
     * @throws EntityNonTrouveeException si non trouvée
     */
    public Formation getFormationParCode(String code) {
        for (Formation f : formations) {
            if (f.getCode().equals(code)) {
                return f;
            }
        }
        throw new EntityNonTrouveeException("Formation " + code + " introuvable");
    }

    /**
     * Retourne la liste des stagiaires triés par nom.
     * @return liste triée
     */
    public List<Stagiaire> getStagiairesTriesParNom() {
        List<Stagiaire> list = new ArrayList<>(stagiaires);
        list.sort(Comparator.comparing(Stagiaire::getNom));
        return list;
    }

    /**
     * Retourne la liste des formations triées par durée (croissante).
     * @return liste triée
     */
    public List<Formation> getFormationsTrieesParDuree() {
        List<Formation> list = new ArrayList<>(formations);
        list.sort(Comparator.comparingInt(Formation::getDureeJours));
        return list;
    }

    /**
     * Retourne la liste des stagiaires inscrits à une formation donnée.
     * @param code code de la formation
     * @return liste des stagiaires
     * @throws EntityNonTrouveeException si formation non trouvée
     */
    public List<Stagiaire> getStagiairesParFormation(String code) {
        Formation f = getFormationParCode(code);
        return List.copyOf(f.getStagiaires());
    }

    /**
     * Recherche un stagiaire par identifiant.
     * @param id identifiant du stagiaire
     * @return stagiaire trouvé
     * @throws EntityNonTrouveeException si non trouvé
     */
    public Stagiaire getStagiaireParId(int id) {
        for (Stagiaire s : stagiaires) {
            if (s.getId() == id) {
                return s;
            }
        }
        throw new EntityNonTrouveeException("Stagiaire " + id + " introuvable");
    }

    public List<Formation> getFormations() {
        return formations;
    }
}
