package fr.phoenyx.arena.exceptions.battle;

import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.battle.Battle;

public class BattleException extends RuntimeException {

    private static final long serialVersionUID = -3847144124386556631L;

    public BattleException(String message) {
        super(message);
    }

    public static final GenericEntityException entityNotFound(Object details) {
        return GenericEntityException.entityNotFound(Battle.class, details);
    }
}
