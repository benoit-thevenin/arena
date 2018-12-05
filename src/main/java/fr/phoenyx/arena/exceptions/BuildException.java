package fr.phoenyx.arena.exceptions;

import static fr.phoenyx.arena.constants.MessagesConstants.BUILD_ILLEGAL_ACTIVE_SKILLS;
import static fr.phoenyx.arena.constants.MessagesConstants.BUILD_ILLEGAL_PASSIVE_SKILLS;
import static fr.phoenyx.arena.constants.MessagesConstants.BUILD_ILLEGAL_STUFF;
import static fr.phoenyx.arena.constants.MessagesConstants.BUILD_ZERO_ACTIVE_SKILL;

import fr.phoenyx.arena.models.Build;

public class BuildException extends RuntimeException {

    private static final long serialVersionUID = -1362467071955301250L;

    public BuildException(String message) {
        super(message);
    }

    public static final GenericEntityException entityNotFound(Object details) {
        return GenericEntityException.entityNotFound(Build.class, details);
    }

    public static final BuildException zeroActiveSkill() {
        return new BuildException(BUILD_ZERO_ACTIVE_SKILL);
    }

    public static final BuildException illegalNumberOfActiveSkills() {
        return new BuildException(BUILD_ILLEGAL_ACTIVE_SKILLS);
    }

    public static final BuildException illegalNumberOfPassiveSkills() {
        return new BuildException(BUILD_ILLEGAL_PASSIVE_SKILLS);
    }

    public static final BuildException illegalStuff() {
        return new BuildException(BUILD_ILLEGAL_STUFF);
    }
}
