package fr.phoenyx.arena.exceptions.guild;

import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.guild.Guild;

public class GuildException extends RuntimeException {

    private static final long serialVersionUID = -4395665504532828402L;

    public GuildException(String message) {
        super(message);
    }

    public static final GenericEntityException entityNotFound(Object details) {
        return GenericEntityException.entityNotFound(Guild.class, details);
    }
}
