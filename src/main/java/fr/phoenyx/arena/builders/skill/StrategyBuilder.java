package fr.phoenyx.arena.builders.skill;

import fr.phoenyx.arena.builders.GenericEntityBuilder;
import fr.phoenyx.arena.models.skill.Strategy;

public class StrategyBuilder extends GenericEntityBuilder<Strategy> {

    private Strategy strategy;

    public StrategyBuilder() {
        strategy = new Strategy();
    }

    @Override
    protected Strategy getEntity() {
        return strategy;
    }

    public StrategyBuilder targetPredicate(String targetPredicate) {
        strategy.setTargetPredicate(targetPredicate);
        return this;
    }

    public StrategyBuilder priority(int priority) {
        strategy.setPriority(priority);
        return this;
    }

    public StrategyBuilder buff(boolean buff) {
        strategy.setBuff(buff);
        return this;
    }
}
