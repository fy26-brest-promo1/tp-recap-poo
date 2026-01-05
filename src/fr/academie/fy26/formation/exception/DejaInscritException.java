package fr.academie.fy26.formation.exception;

/** Exception : stagiaire déjà inscrit. */
public class DejaInscritException extends RuntimeException {
    public DejaInscritException(String msg) { super(msg); }
}
