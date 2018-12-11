package fr.phoenyx.arena.builders.battle;

import java.util.Set;

import fr.phoenyx.arena.builders.GenericEntityBuilder;
import fr.phoenyx.arena.models.battle.Action;
import fr.phoenyx.arena.models.battle.Hero;
import fr.phoenyx.arena.models.battle.Round;

public class RoundBuilder extends GenericEntityBuilder<Round> {

    private Round round;

    public RoundBuilder() {
        round = new Round();
    }

    @Override
    protected Round getEntity() {
        return round;
    }

    public RoundBuilder roundNumber(int roundNumber) {
        round.setRoundNumber(roundNumber);
        return this;
    }

    public RoundBuilder actionsPerformed(Set<Action> actionsPerformed) {
        round.setActionsPerformed(actionsPerformed);
        return this;
    }

    public RoundBuilder heroes(Set<Hero> heroes) {
        round.setHeroes(heroes);
        return this;
    }
}
