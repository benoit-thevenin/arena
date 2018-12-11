package fr.phoenyx.arena.builders.skill;

import fr.phoenyx.arena.builders.GenericEntityBuilder;
import fr.phoenyx.arena.enums.skill.PassiveSkillEnum;
import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.models.skill.PassiveSkill;


public class PassiveSkillBuilder extends GenericEntityBuilder<PassiveSkill> {

    private PassiveSkill passiveSkill;

    public PassiveSkillBuilder() {
        passiveSkill = new PassiveSkill();
    }

    @Override
    protected PassiveSkill getEntity() {
        return passiveSkill;
    }

    public PassiveSkillBuilder build(Build build) {
        passiveSkill.setBuild(build);
        return this;
    }

    public PassiveSkillBuilder passiveSkillEnum(PassiveSkillEnum passiveSkillEnum) {
        passiveSkill.setPassiveSkillEnum(passiveSkillEnum);
        return this;
    }
}
