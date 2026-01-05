package fr.academie.fy26.formation.util;

import java.util.List;

/**
 * Afficheur générique pour listes d'éléments.
 */
public class Afficheur<T> {

    /**
     * Affiche les éléments d'une liste.
     * @param elements la liste des éléments à afficher
     */
    public void afficher(List<T> elements) {
        for (T e : elements) {
            IO.println(e);
        }
    }
}
