package fr.academie.fy26.formation.exception;

/** Exception : capacité formation atteinte. */
public class CapaciteFormationAtteinteException extends RuntimeException {
    public CapaciteFormationAtteinteException(String msg) { super(msg); }
}
