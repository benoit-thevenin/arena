package fr.phoenyx.arena.dtos.battle;

import java.util.HashSet;
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
    private Set<RoundDTO> rounds = new HashSet<>();

    public BattleDTO() {
        super();
    }

    public BattleDTO(Battle battle) {
        super(battle);
        if (battle.getTeam1() != null) {
            team1 = new TeamDTO(battle.getTeam1());
        }
        if (battle.getTeam2() != null) {
            team2 = new TeamDTO(battle.getTeam2());
        }
        rounds = battle.getRounds().stream()
                .map(RoundDTO::new)
                .collect(Collectors.toSet());
    }
}
