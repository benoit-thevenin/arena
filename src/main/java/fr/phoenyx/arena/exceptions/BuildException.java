package fr.phoenyx.arena.exceptions;

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
        return new BuildException("At least one active skill must be selected");
    }

    public static final BuildException illegalNumberOfActiveSkills() {
        return new BuildException("No more than 4 active skills can be selected");
    }

    public static final BuildException illegalNumberOfPassiveSkills() {
        return new BuildException("No more than 4 passive skills can be selected");
    }

    public static final BuildException illegalStuff() {
        return new BuildException("An item slot can be used only once per build");
    }
}
