package fr.phoenyx.arena.exceptions.battle;

import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.battle.HeroBuild;

public class HeroBuildException extends RuntimeException {

    private static final long serialVersionUID = 1216632307807250468L;

    public HeroBuildException(String message) {
        super(message);
    }

    public static final GenericEntityException entityNotFound(Object details) {
        return GenericEntityException.entityNotFound(HeroBuild.class, details);
    }
}
