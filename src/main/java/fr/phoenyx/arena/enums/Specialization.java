package fr.phoenyx.arena.enums;

public enum Specialization {
    TANK("Tank"),
    DAMAGE_DEALER("Damage dealer"),
    SUPPORT("Support");

    private String description;

    private Specialization(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
