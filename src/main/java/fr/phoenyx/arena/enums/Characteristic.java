package fr.phoenyx.arena.enums;

public enum Characteristic {
    VITALITY(true, 5, 10, Double.POSITIVE_INFINITY),
    STRENGTH(true, 3, 5, Double.POSITIVE_INFINITY),
    INTELLIGENCE(true, 3, 5, Double.POSITIVE_INFINITY),
    AGILITY(true, 3, 5, Double.POSITIVE_INFINITY);

    private boolean primaryCharacteristic;
    private int minPerLevel;
    private int maxPerLevel;
    private double max;

    Characteristic(boolean primaryCharacteristic, int minPerLevel, int maxPerLevel, double max) {
        this.primaryCharacteristic = primaryCharacteristic;
        this.minPerLevel = minPerLevel;
        this.maxPerLevel = maxPerLevel;
        this.max = max;
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
