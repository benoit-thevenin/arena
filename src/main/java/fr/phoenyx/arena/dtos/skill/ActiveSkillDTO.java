package fr.phoenyx.arena.dtos.skill;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.dtos.TypeDTO;
import fr.phoenyx.arena.enums.skill.ActiveSkillEnum;
import fr.phoenyx.arena.models.skill.ActiveSkill;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ActiveSkillDTO extends GenericEntityDTO {

    private String name;
    private String description;
    private int cooldown;
    private int baseManaCost;
    private int basePower;
    private int targetNumber;
    private boolean buff;
    private TypeDTO type;
    private EffectDTO onHitEffect;
    private StrategyDTO strategy;

    public ActiveSkillDTO() {
        super();
    }

    public ActiveSkillDTO(ActiveSkill activeSkill) {
        super(activeSkill);
        ActiveSkillEnum activeSkillEnum = activeSkill.getActiveSkillEnum();
        name = activeSkillEnum.getName();
        description = activeSkillEnum.getDescription();
        cooldown = activeSkillEnum.getCooldown();
        baseManaCost = activeSkillEnum.getBaseManaCost();
        basePower = activeSkillEnum.getBasePower();
        targetNumber = activeSkillEnum.getTargetNumber();
        buff = activeSkillEnum.isBuff();
        if (activeSkillEnum.getType() != null) {
            type = new TypeDTO(activeSkillEnum.getType());
        }
        if (activeSkillEnum.getOnHitEffect() != null) {
            onHitEffect = new EffectDTO(activeSkillEnum.getOnHitEffect());
        }
        if (activeSkill.getStrategy() != null) {
            strategy = new StrategyDTO(activeSkill.getStrategy());
        }
    }
}
