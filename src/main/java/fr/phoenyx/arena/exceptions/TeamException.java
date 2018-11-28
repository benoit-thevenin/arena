package fr.phoenyx.arena.exceptions;

import fr.phoenyx.arena.models.Team;

public class TeamException extends RuntimeException {

    private static final long serialVersionUID = -4651235382416349385L;

    public TeamException(String message) {
        super(message);
    }

    public static final GenericEntityException entityNotFound(Object details) {
        return GenericEntityException.entityNotFound(Team.class, details);
    }
}
