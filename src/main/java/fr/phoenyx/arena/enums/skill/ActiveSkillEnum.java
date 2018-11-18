package fr.phoenyx.arena.enums.skill;

import fr.phoenyx.arena.enums.Type;

public enum ActiveSkillEnum {
    PHYSICAL_STRIKE("Physical strike", "A basic physical strike", 0, 0, 10, 1, false, Type.PHYSICAL, null),
    FROST_STRIKE("Frost strike", "A basic frost strike", 0, 0, 10, 1, false, Type.FROST, null),
    FIRE_STRIKE("Fire strike", "A basic fire strike", 0, 0, 10, 1, false, Type.FIRE, null),
    FROST_MISSILE("Frost missile", "A basic frost missile", 0, 0, 10, 1, false, Type.FROST, null),
    FIRE_MISSILE("Fire missile", "A basic fire missile", 0, 0, 10, 1, false, Type.FIRE, null),
    ARCANES_MISSILE("Arcanes missile", "A basic arcanes missile", 0, 0, 10, 1, false, Type.ARCANES, null),
    PHYSICAL_SHOT("Physical shot", "A basic physical shot", 0, 0, 10, 1, false, Type.PHYSICAL, null),
    POISON_SHOT("Poison shot", "A basic poison shot", 0, 0, 10, 1, false, Type.POISON, null),
    FROST_NOVA("Frost nova", "A nova that freezes the enemies", 4, 80, 100, 5, false, Type.FROST, Effect.FREEZE);

    private String name;
    private String description;
    private int cooldown;
    private int baseManaCost;
    private int basePower;
    private int targetNumber;
    private boolean buff;
    private Type type;
    private Effect onHitEffect;

    ActiveSkillEnum(String name, String description, int cooldown, int baseManaCost, int basePower,
                    int targetNumber, boolean buff, Type type, Effect onHitEffect) {
        this.name = name;
        this.description = description;
        this.cooldown = cooldown;
        this.baseManaCost = baseManaCost;
        this.basePower = basePower;
        this.targetNumber = targetNumber;
        this.buff = buff;
        this.type = type;
        this.onHitEffect = onHitEffect;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCooldown() {
        return cooldown;
    }

    public int getBaseManaCost() {
        return baseManaCost;
    }

    public int getBasePower() {
        return basePower;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public boolean isBuff() {
        return buff;
    }

    public Type getType() {
        return type;
    }

    public Effect getOnHitEffect() {
        return onHitEffect;
    }
}
