package fr.phoenyx.arena.dtos.skill;

import fr.phoenyx.arena.enums.skill.Effect;
import lombok.Data;

@Data
public class EffectDTO {

    private String name;
    private String description;
    private int duration;
    private int extendable;
    private boolean stackable;

    public EffectDTO() {
        super();
    }

    public EffectDTO(Effect effect) {
        this();
        name = effect.getName();
        description = effect.getDescription();
        duration = effect.getDuration();
        extendable = effect.getExtendable();
        stackable = effect.isStackable();
    }
}
