package fr.academie.fy26.formation.service;

import fr.academie.fy26.formation.model.Formation;
import fr.academie.fy26.formation.model.Stagiaire;

/**
 * Service d'inscription et de désinscription des stagiaires à une formation.
 */
public interface InscriptionService {
    /**
     * Inscrit un stagiaire à une formation.
     *
     * @param stagiaire le stagiaire à inscrire
     * @param formation la formation à laquelle inscrire le stagiaire
     */
    void inscrire(Stagiaire stagiaire, Formation formation);

    /**
     * Désinscrit un stagiaire d'une formation.
     *
     * @param stagiaire le stagiaire à désinscrire
     * @param formation la formation dont désinscrire le stagiaire
     */
    void desinscrire(Stagiaire stagiaire, Formation formation);
}
