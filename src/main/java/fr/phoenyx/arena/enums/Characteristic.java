package fr.phoenyx.arena.enums;

public enum Characteristic {
    VITALITY("Vitality", true, 5, 10, Double.POSITIVE_INFINITY),
    STRENGTH("Strength", true, 3, 5, Double.POSITIVE_INFINITY),
    INTELLIGENCE("Intelligence", true, 3, 5, Double.POSITIVE_INFINITY),
    AGILITY("Agility", true, 3, 5, Double.POSITIVE_INFINITY);

    private String description;
    private boolean primaryCharacteristic;
    private int minPerLevel;
    private int maxPerLevel;
    private double max;

    Characteristic(String description, boolean primaryCharacteristic, int minPerLevel, int maxPerLevel, double max) {
        this.description = description;
        this.primaryCharacteristic = primaryCharacteristic;
        this.minPerLevel = minPerLevel;
        this.maxPerLevel = maxPerLevel;
        this.max = max;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPrimaryCharacteristic() {
        return primaryCharacteristic;
    }

    public int getMinPerLevel() {
        return minPerLevel;
    }

    public int getMaxPerLevel() {
        return maxPerLevel;
    }

    public double getMax() {
        return max;
    }
}
