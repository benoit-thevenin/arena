package fr.phoenyx.arena.exceptions;

import fr.phoenyx.arena.models.Applicant;

public class ApplicantException extends RuntimeException {

    private static final long serialVersionUID = -3079468514742175613L;

    public ApplicantException(String message) {
        super(message);
    }

    public static final GenericEntityException entityNotFound(Object details) {
        return GenericEntityException.entityNotFound(Applicant.class, details);
    }
}
