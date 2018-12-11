package fr.phoenyx.arena.builders.battle;

import java.util.Set;

import fr.phoenyx.arena.builders.GenericEntityBuilder;
import fr.phoenyx.arena.models.Team;
import fr.phoenyx.arena.models.battle.Battle;
import fr.phoenyx.arena.models.battle.Round;

public class BattleBuilder extends GenericEntityBuilder<Battle> {

    private Battle battle;

    public BattleBuilder() {
        battle = new Battle();
    }

    @Override
    protected Battle getEntity() {
        return battle;
    }

    public BattleBuilder team1(Team team1) {
        battle.setTeam1(team1);
        return this;
    }

    public BattleBuilder team2(Team team2) {
        battle.setTeam2(team2);
        return this;
    }

    public BattleBuilder rounds(Set<Round> rounds) {
        battle.setRounds(rounds);
        return this;
    }
}
