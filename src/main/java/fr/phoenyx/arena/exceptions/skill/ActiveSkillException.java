package fr.phoenyx.arena.exceptions.skill;

import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.skill.ActiveSkill;

public class ActiveSkillException extends RuntimeException {

    private static final long serialVersionUID = 2687804139223192589L;

    public ActiveSkillException(String message) {
        super(message);
    }

    public static final GenericEntityException entityNotFound(Object details) {
        return GenericEntityException.entityNotFound(ActiveSkill.class, details);
    }
}
