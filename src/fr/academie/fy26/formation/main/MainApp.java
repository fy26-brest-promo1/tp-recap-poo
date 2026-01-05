package fr.academie.fy26.formation.main;

import fr.academie.fy26.formation.exception.*;
import fr.academie.fy26.formation.model.*;
import fr.academie.fy26.formation.service.*;
import fr.academie.fy26.formation.util.*;

/**
 * Classe principale de démonstration de l'application Centre de formation.
 */
public class MainApp {


    void main() {
        CentreFormation centre = new CentreFormation();
        creerFormateursEtFormations(centre);
        creerStagiaires(centre);

        InscriptionService service = new InscriptionServiceImpl();
        inscrireStagiaires(centre, service);
        afficherResultats(centre);

        declencherExceptionAttendue(service, centre);
    }

    private void creerFormateursEtFormations(CentreFormation centre) {
        Formateur f1 = new Formateur(1, "Dupont", "Alice", "Java", 8);
        Formateur f2 = new Formateur(2, "Martin", "Bob", "Python", 2);
        centre.ajouterFormateur(f1);
        centre.ajouterFormateur(f2);

        Formation fo1 = new Formation(CodeFormationGenerator.genererCode("JAVA", 2026), "Java POO", 5, f1);
        Formation fo2 = new Formation(CodeFormationGenerator.genererCode("PYTHON", 2026), "Python débutant", 3, f2);
        Formation fo3 = new Formation(CodeFormationGenerator.genererCode("JAVA", 2026), "Java avancé", 7, f1);
        centre.ajouterFormation(fo1);
        centre.ajouterFormation(fo2);
        centre.ajouterFormation(fo3);
    }

    private void creerStagiaires(CentreFormation centre) {
        centre.ajouterStagiaire(new Stagiaire(1, "Durand", "Claire", "Débutant"));
        centre.ajouterStagiaire(new Stagiaire(2, "Petit", "David", "Intermédiaire"));
        centre.ajouterStagiaire(new Stagiaire(3, "Leroy", "Emma", "Avancé"));
        centre.ajouterStagiaire(new Stagiaire(4, "Moreau", "Lucas", "Débutant"));
        centre.ajouterStagiaire(new Stagiaire(5, "Simon", "Eva", "Intermédiaire"));
        centre.ajouterStagiaire(new Stagiaire(6, "Roux", "Noah", "Avancé"));
        centre.ajouterStagiaire(new Stagiaire(7, "Fournier", "Léa", "Débutant"));
        centre.ajouterStagiaire(new Stagiaire(8, "Mercier", "Hugo", "Intermédiaire"));
    }

    private void inscrireStagiaires(CentreFormation centre, InscriptionService service) {
        service.inscrire(centre.getStagiaireParId(1), centre.getFormationParCode("JAVA-2026-001"));
        service.inscrire(centre.getStagiaireParId(2), centre.getFormationParCode("JAVA-2026-003"));
        service.inscrire(centre.getStagiaireParId(3), centre.getFormationParCode("PYTHON-2026-002"));
        service.inscrire(centre.getStagiaireParId(4), centre.getFormationParCode("JAVA-2026-001"));
        service.inscrire(centre.getStagiaireParId(5), centre.getFormationParCode("JAVA-2026-003"));
        service.inscrire(centre.getStagiaireParId(6), centre.getFormationParCode("PYTHON-2026-002"));
        service.inscrire(centre.getStagiaireParId(7), centre.getFormationParCode("JAVA-2026-001"));
        service.inscrire(centre.getStagiaireParId(8), centre.getFormationParCode("JAVA-2026-001"));
    }

    private void afficherResultats(CentreFormation centre) {
        Afficheur<Stagiaire> stagiaireAfficheur = new Afficheur<>();
        Afficheur<Formation> formationAfficheur = new Afficheur<>();

        IO.println("Stagiaires triés par nom :");
        stagiaireAfficheur.afficher(centre.getStagiairesTriesParNom());

        IO.println("\nFormations triées par durée :");
        formationAfficheur.afficher(centre.getFormationsTrieesParDuree());

        IO.println("\nStagiaires de la première formation :");
        if (!centre.getFormations().isEmpty()) {
            Formation fo1 = centre.getFormations().getFirst();
            stagiaireAfficheur.afficher(centre.getStagiairesParFormation(fo1.getCode()));
        }
    }

    private void declencherExceptionAttendue(InscriptionService service, CentreFormation centre) {
        try {
            Stagiaire s1 = centre.getStagiaireParId(1);
            Formation fo1 = centre.getFormationParCode("JAVA-2026-001");
            service.inscrire(s1, fo1); // déjà inscrit
        } catch (DejaInscritException e) {
            IO.println("\n[Exception attendue] " + e.getMessage());
        }

        try {
            Stagiaire s4 = centre.getStagiaireParId(4);
            Formation fo1 = centre.getFormationParCode("PYTHON-2026-002");
            service.inscrire(s4, fo1); // capacité atteinte
        } catch (CapaciteFormationAtteinteException e) {
            IO.println("\n[Exception attendue] " + e.getMessage());
        }
    }
}
