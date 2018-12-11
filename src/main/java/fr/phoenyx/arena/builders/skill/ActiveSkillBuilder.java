package fr.phoenyx.arena.builders.skill;

import fr.phoenyx.arena.builders.GenericEntityBuilder;
import fr.phoenyx.arena.enums.skill.ActiveSkillEnum;
import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.models.skill.ActiveSkill;
import fr.phoenyx.arena.models.skill.Strategy;

public class ActiveSkillBuilder extends GenericEntityBuilder<ActiveSkill> {

    private ActiveSkill activeSkill;

    public ActiveSkillBuilder() {
        activeSkill = new ActiveSkill();
    }

    @Override
    protected ActiveSkill getEntity() {
        return activeSkill;
    }

    public ActiveSkillBuilder build(Build build) {
        activeSkill.setBuild(build);
        return this;
    }

    public ActiveSkillBuilder activeSkillEnum(ActiveSkillEnum activeSkillEnum) {
        activeSkill.setActiveSkillEnum(activeSkillEnum);
        return this;
    }

    public ActiveSkillBuilder strategy(Strategy strategy) {
        activeSkill.setStrategy(strategy);
        return this;
    }
}
