package fr.phoenyx.arena.dtos.skill;

import fr.phoenyx.arena.dtos.CharacteristicDTO;
import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.enums.skill.PassiveSkillEnum;
import fr.phoenyx.arena.models.skill.PassiveSkill;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PassiveSkillDTO extends GenericEntityDTO {

    private String name;
    private String description;
    private CharacteristicDTO characteristic;
    private EffectDTO onBeingHitEffect;

    public PassiveSkillDTO() {
        super();
    }

    public PassiveSkillDTO(PassiveSkill passiveSkill) {
        super(passiveSkill);
        PassiveSkillEnum passiveSkillEnum = passiveSkill.getPassiveSkill();
        name = passiveSkillEnum.getName();
        description = passiveSkillEnum.getDescription();
        if (passiveSkillEnum.getCharacteristic() != null) {
            characteristic = new CharacteristicDTO(passiveSkillEnum.getCharacteristic());
        }
        if (passiveSkillEnum.getOnBeingHitEffect() != null) {
            onBeingHitEffect = new EffectDTO(passiveSkillEnum.getOnBeingHitEffect());
        }
    }
}
