package fr.phoenyx.arena.exceptions.item;

import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.item.Bonus;

public class BonusException extends RuntimeException {

    private static final long serialVersionUID = -531906570548441448L;

    public BonusException(String message) {
        super(message);
    }

    public static final GenericEntityException entityNotFound(Object details) {
        return GenericEntityException.entityNotFound(Bonus.class, details);
    }
}
