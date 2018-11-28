package fr.phoenyx.arena.exceptions.battle;

import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.battle.Round;

public class RoundException extends RuntimeException {

    private static final long serialVersionUID = 768727270378162188L;

    public RoundException(String message) {
        super(message);
    }

    public static final GenericEntityException entityNotFound(Object details) {
        return GenericEntityException.entityNotFound(Round.class, details);
    }
}
