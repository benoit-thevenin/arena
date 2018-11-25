package fr.phoenyx.arena.dtos.battle;

import java.util.List;
import java.util.stream.Collectors;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.models.battle.Round;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RoundDTO extends GenericEntityDTO implements Comparable<RoundDTO> {

    private int roundNumber;
    private List<ActionDTO> actionsPerformed;
    private List<HeroDTO> heroes;

    public RoundDTO() {
        super();
    }

    public RoundDTO(Round round) {
        super(round);
        roundNumber = round.getRoundNumber();
        actionsPerformed = round.getActionsPerformed().stream()
                .map(action -> new ActionDTO(action))
                .collect(Collectors.toList());
        heroes = round.getHeroes().stream()
                .map(hero -> new HeroDTO(hero))
                .collect(Collectors.toList());
    }

    @Override
    public int compareTo(RoundDTO other) {
        return Integer.compare(roundNumber, other.getRoundNumber());
    }
}
