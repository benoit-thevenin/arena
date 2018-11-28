package fr.phoenyx.arena.exceptions.battle;

import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.battle.Action;

public class ActionException extends RuntimeException {

    private static final long serialVersionUID = 3508166170154115950L;

    public ActionException(String message) {
        super(message);
    }

    public static final GenericEntityException entityNotFound(Object details) {
        return GenericEntityException.entityNotFound(Action.class, details);
    }
}
