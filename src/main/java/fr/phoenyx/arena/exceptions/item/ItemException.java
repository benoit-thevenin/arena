package fr.phoenyx.arena.exceptions.item;

import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.item.Item;

public class ItemException extends RuntimeException {

    private static final long serialVersionUID = 2734761698250547014L;

    public ItemException(String message) {
        super(message);
    }

    public static final GenericEntityException entityNotFound(Object details) {
        return GenericEntityException.entityNotFound(Item.class, details);
    }
}
