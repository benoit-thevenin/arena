package fr.phoenyx.arena.exceptions.skill;

import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.skill.PassiveSkill;

public class PassiveSkillException extends RuntimeException {

    private static final long serialVersionUID = 2655153142126123729L;

    public PassiveSkillException(String message) {
        super(message);
    }

    public static final GenericEntityException entityNotFound(Object details) {
        return GenericEntityException.entityNotFound(PassiveSkill.class, details);
    }
}
