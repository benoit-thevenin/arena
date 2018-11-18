package fr.phoenyx.arena.enums.item;

public enum ItemSlot {
    HEAD("Head"),
    SHOULDERS("Shoulders"),
    HANDS("Hands"),
    TORSO("Torso"),
    LEGS("Legs"),
    FEET("Feet"),
    BELT("Belt"),
    WRIST("Wrist"),
    RIGHT_HAND("Right Hand"),
    LEFT_HAND("Left Hand"),
    FINGER1("First finger"),
    FINGER2("Second finger"),
    NECK("Neck");

    private String description;

    ItemSlot(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
