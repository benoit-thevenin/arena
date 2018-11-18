package fr.phoenyx.arena.enums.item;

public enum Rarity {
    COMMON("Common", 1),
    MAGIC("Magic", 2),
    RARE("Rare", 4),
    EPIC("Epic", 5),
    LEGENDARY("Legendary", 6),
    SET("Set", 6);

    private String description;
    private int numberOfAffixes;

    Rarity(String description, int numberOfAffixes) {
        this.description = description;
        this.numberOfAffixes = numberOfAffixes;
    }

    public String getDescription() {
        return description;
    }

    public int getNumberOfAffixes() {
        return numberOfAffixes;
    }
}
