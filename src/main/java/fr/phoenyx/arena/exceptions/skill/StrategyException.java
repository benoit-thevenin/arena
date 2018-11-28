package fr.phoenyx.arena.exceptions.skill;

import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.skill.Strategy;

public class StrategyException extends RuntimeException {

    private static final long serialVersionUID = -5042971707593207105L;

    public StrategyException(String message) {
        super(message);
    }

    public static final GenericEntityException entityNotFound(Object details) {
        return GenericEntityException.entityNotFound(Strategy.class, details);
    }
}
