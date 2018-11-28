package fr.phoenyx.arena.exceptions.battle;

import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.battle.Hero;

public class HeroException extends RuntimeException {

    private static final long serialVersionUID = -2678338580092610506L;

    public HeroException(String message) {
        super(message);
    }

    public static final GenericEntityException entityNotFound(Object details) {
        return GenericEntityException.entityNotFound(Hero.class, details);
    }
}
