package fr.phoenyx.arena.enums.skill;

import fr.phoenyx.arena.enums.item.Characteristic;

public enum PassiveSkillEnum {
    BRUTE("Brute", "Increase strength by 20%", Characteristic.STRENGTH, null);

    private String name;
    private String description;
    private Characteristic characteristic;
    private Effect onBeingHitEffect;

    PassiveSkillEnum(String name, String description, Characteristic characteristic, Effect onBeingHitEffect) {
        this.name = name;
        this.description = description;
        this.characteristic = characteristic;
        this.onBeingHitEffect = onBeingHitEffect;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Characteristic getCharacteristic() {
        return characteristic;
    }

    public Effect getOnBeingHitEffect() {
        return onBeingHitEffect;
    }
}
