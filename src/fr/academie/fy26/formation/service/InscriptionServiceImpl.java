package fr.academie.fy26.formation.service;

import fr.academie.fy26.formation.exception.CapaciteFormationAtteinteException;
import fr.academie.fy26.formation.exception.DejaInscritException;
import fr.academie.fy26.formation.exception.DonneeInvalideException;
import fr.academie.fy26.formation.model.Formation;
import fr.academie.fy26.formation.model.Stagiaire;

/**
 * Implémentation du service d'inscription et de désinscription des stagiaires à une formation.
 */
public class InscriptionServiceImpl implements InscriptionService {
    @Override
    /**
     * {@inheritDoc}
     */
    public void inscrire(Stagiaire stagiaire, Formation formation) {
        if (formation.getStagiaires().size() >= Formation.MAX_STAGIAIRES)
            throw new CapaciteFormationAtteinteException("Formation pleine");
        if (formation.getStagiaires().size() >= formation.getFormateur().getCapaciteMaxStagiaires())
            throw new CapaciteFormationAtteinteException("Formation pleine (choix du formateur)");
        if (formation.getStagiaires().contains(stagiaire))
            throw new DejaInscritException("Déjà inscrit");
        formation.getStagiaires().add(stagiaire);
        stagiaire.getFormations().add(formation);
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public void desinscrire(Stagiaire stagiaire, Formation formation) {
        if (!formation.getStagiaires().contains(stagiaire))
            throw new DonneeInvalideException("Stagiaire non inscrit");
        formation.getStagiaires().remove(stagiaire);
        stagiaire.getFormations().remove(formation);
    }
}
