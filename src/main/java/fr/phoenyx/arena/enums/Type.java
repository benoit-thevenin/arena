package fr.phoenyx.arena.enums;

import java.util.Arrays;

public enum Type {
    PHYSICAL("Physical", Characteristic.STRENGTH, Characteristic.AGILITY),
    FROST("Frost", Characteristic.STRENGTH, Characteristic.INTELLIGENCE),
    FIRE("Fire", Characteristic.STRENGTH, Characteristic.INTELLIGENCE),
    ARCANES("Arcanes", Characteristic.INTELLIGENCE),
    POISON("Poison", Characteristic.AGILITY);

    private String description;
    private Characteristic[] characteristics;

    Type(String description, Characteristic... characteristics) {
        this.description = description;
        this.characteristics = characteristics;
    }

    public String getDescription() {
        return description;
    }

    public Characteristic[] getCharacteristics() {
        return characteristics;
    }

    public boolean isBuffedBy(Characteristic characteristic) {
        return Arrays.stream(characteristics).anyMatch(c -> c.equals(characteristic));
    }
}
