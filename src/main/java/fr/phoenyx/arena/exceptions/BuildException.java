package fr.phoenyx.arena.exceptions;

public class BuildException extends RuntimeException {

    private static final long serialVersionUID = -1362467071955301250L;

    public BuildException(String message) {
        super(message);
    }

    public static final BuildException zeroActiveSkillException() {
        return new BuildException("At least one active skill must be selected");
    }

    public static final BuildException illegalNumberOfActiveSkillsException() {
        return new BuildException("No more than 4 active skills can be selected");
    }

    public static final BuildException illegalNumberOfPassiveSkillsException() {
        return new BuildException("No more than 4 passive skills can be selected");
    }

    public static final BuildException illegalStuffException() {
        return new BuildException("An item slot can be used only once per build");
    }
}
