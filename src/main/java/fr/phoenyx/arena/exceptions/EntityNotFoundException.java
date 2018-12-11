package fr.phoenyx.arena.exceptions;

import static fr.phoenyx.arena.constants.MessagesConstants.NOT_FOUND;

import fr.phoenyx.arena.models.GenericEntity;

public class EntityNotFoundException extends Exception {

    private static final long serialVersionUID = 1809375944006220868L;

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(Class<? extends GenericEntity> clazz, Object details) {
        this(String.join(" ", clazz.getSimpleName(), NOT_FOUND, details.toString()));
    }
}
