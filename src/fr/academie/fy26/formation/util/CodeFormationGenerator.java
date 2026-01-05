package fr.academie.fy26.formation.util;

/**
 * Générateur de codes formation (ex : JAVA-2026-001).
 */
public class CodeFormationGenerator {
    private static int compteur = 1;
/**
     * Génère un code formation unique.
     *
     * @param prefixe le préfixe du code (ex : "JAVA")
     * @param annee l'année de la formation (ex : 2026)
     * @return le code formation généré (ex : "JAVA-2026-001")
     */

    public static String genererCode(String prefixe, int annee) {
        String code = String.format("%s-%d-%03d", prefixe, annee, compteur);
        compteur++;
        return code;
    }
}
