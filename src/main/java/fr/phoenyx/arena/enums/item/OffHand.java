package fr.phoenyx.arena.enums.item;

public enum OffHand {
    SHIELD("Shield"),
    QUIVER("Quiver"),
    MAGIC_ORB("Magic orb");

    private String description;

    OffHand(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
