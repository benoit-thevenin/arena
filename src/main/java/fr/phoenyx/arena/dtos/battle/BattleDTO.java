package fr.phoenyx.arena.dtos.battle;

import java.util.Set;
import java.util.stream.Collectors;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.dtos.TeamDTO;
import fr.phoenyx.arena.models.battle.Battle;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BattleDTO extends GenericEntityDTO {

    private TeamDTO team1;
    private TeamDTO team2;
    private Set<RoundDTO> rounds;

    public BattleDTO() {
        super();
    }

    public BattleDTO(Battle battle) {
        super(battle);
        team1 = new TeamDTO(battle.getTeam1());
        team2 = new TeamDTO(battle.getTeam2());
        rounds = battle.getRounds().stream()
                .map(round -> new RoundDTO(round))
                .collect(Collectors.toSet());
    }
}
