package fr.academie.fy26.formation.exception;

/** Exception : entité non trouvée. */
public class EntityNonTrouveeException extends RuntimeException {
    public EntityNonTrouveeException(String msg) { super(msg); }
}
