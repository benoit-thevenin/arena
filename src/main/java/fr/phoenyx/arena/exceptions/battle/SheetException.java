package fr.phoenyx.arena.exceptions.battle;

import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.battle.Sheet;

public class SheetException extends RuntimeException {

    private static final long serialVersionUID = 6068922914245571995L;

    public SheetException(String message) {
        super(message);
    }

    public static final GenericEntityException entityNotFound(Object details) {
        return GenericEntityException.entityNotFound(Sheet.class, details);
    }
}
