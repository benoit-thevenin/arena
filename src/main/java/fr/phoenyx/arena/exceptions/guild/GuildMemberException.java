package fr.phoenyx.arena.exceptions.guild;

import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.guild.GuildMember;

public class GuildMemberException extends RuntimeException {

    private static final long serialVersionUID = 3353936541368519697L;

    public GuildMemberException(String message) {
        super(message);
    }

    public static final GenericEntityException entityNotFound(Object details) {
        return GenericEntityException.entityNotFound(GuildMember.class, details);
    }
}
