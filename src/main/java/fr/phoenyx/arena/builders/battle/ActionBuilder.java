package fr.phoenyx.arena.builders.battle;

import java.util.Set;

import fr.phoenyx.arena.builders.GenericEntityBuilder;
import fr.phoenyx.arena.models.battle.Action;
import fr.phoenyx.arena.models.battle.Hero;
import fr.phoenyx.arena.models.skill.ActiveSkill;

public class ActionBuilder extends GenericEntityBuilder<Action> {

    private Action action;

    public ActionBuilder() {
        action = new Action();
    }

    @Override
    protected Action getEntity() {
        return action;
    }

    public ActionBuilder actionOrder(int actionOrder) {
        action.setActionOrder(actionOrder);
        return this;
    }

    public ActionBuilder caster(Hero caster) {
        action.setCaster(caster);
        return this;
    }

    public ActionBuilder skill(ActiveSkill skill) {
        action.setSkill(skill);
        return this;
    }

    public ActionBuilder targets(Set<Hero> targets) {
        action.setTargets(targets);
        return this;
    }

    public ActionBuilder rand(double rand) {
        action.setRand(rand);
        return this;
    }
}
