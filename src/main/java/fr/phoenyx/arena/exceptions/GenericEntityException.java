package fr.phoenyx.arena.exceptions;

import fr.phoenyx.arena.models.GenericEntity;

public class GenericEntityException extends RuntimeException {

    private static final long serialVersionUID = 1809375944006220868L;

    public GenericEntityException(String message) {
        super(message);
    }

    public static final GenericEntityException entityNotFound(Class<? extends GenericEntity> clazz, Object details) {
        return new GenericEntityException(clazz.getSimpleName() + " not found : " + details);
    }
}
