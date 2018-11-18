package fr.phoenyx.arena.enums.item;

public enum WeaponType {
    SWORD("Sword", false),
    DAGGER("Dagger", false),
    MACE("Mace", false),
    AXE("Axe", false),
    WAND("Wand", false),
    FIST_WEAPON("Fist weapon", false),
    POLEARM("Polearm", true),
    STAFF("Staff", true),
    TWO_HANDED_SWORD("Two handed sword", true),
    TWO_HANDED_MACE("Two Handed mace", true),
    TWO_HANDED_AXE("Two handed axe", true);

    private String description;
    private boolean twoHanded;

    WeaponType(String description, boolean twoHanded) {
        this.description = description;
        this.twoHanded = twoHanded;
    }

    public String getDescription() {
        return description;
    }

    public boolean isTwoHanded() {
        return twoHanded;
    }
}
