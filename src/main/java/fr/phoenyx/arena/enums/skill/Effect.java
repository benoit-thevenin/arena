package fr.phoenyx.arena.enums.skill;

public enum Effect {
    FREEZE("Freeze", "Freeze : target can not move", 2, 1, false),
    STUN("Stun", "Stun : target can not move", 2, 1, false),
    BURN("Burn", "Burn : target takes damage at the end of the round", 3, 2, false),
    POISON("Poison", "Poison : target takes damage at the end of the round", 3, 0, true);

    private String name;
    private String description;
    private int duration;
    private int extendable;
    private boolean stackable;

    Effect(String name, String description, int duration, int extendable, boolean stackable) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.extendable = extendable;
        this.stackable = stackable;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public int getExtendable() {
        return extendable;
    }

    public boolean isStackable() {
        return stackable;
    }
}
