package fr.phoenyx.arena.exceptions;

import fr.phoenyx.arena.dtos.GenericEntityDTO;

public class BadRequestException extends Exception {

    private static final long serialVersionUID = 1349521763775811908L;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, GenericEntityDTO entity) {
        this(String.join(" ", message, entity.toString()));
    }
}
