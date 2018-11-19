package fr.phoenyx.arena.enums.item;

public enum Power {

    BURN("Burn", 20, "toto");

    private String name;
    private int value;
    private String description;

    Power(String name, int value, String description) {
        this.name = name;
        this.value = value;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
