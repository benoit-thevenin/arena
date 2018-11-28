package fr.phoenyx.arena.exceptions;

import fr.phoenyx.arena.models.Player;

public class PlayerException extends RuntimeException {

    private static final long serialVersionUID = -3012586989327134857L;

    public PlayerException(String message) {
        super(message);
    }

    public static final GenericEntityException entityNotFound(Object details) {
        return GenericEntityException.entityNotFound(Player.class, details);
    }
}
