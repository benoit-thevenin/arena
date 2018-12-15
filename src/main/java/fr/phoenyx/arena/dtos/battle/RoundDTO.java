package fr.phoenyx.arena.dtos.battle;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.models.battle.Round;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RoundDTO extends GenericEntityDTO implements Comparable<RoundDTO> {

    private int roundNumber;
    private Set<ActionDTO> actionsPerformed = new HashSet<>();
    private Set<HeroDTO> heroes = new HashSet<>();

    public RoundDTO() {
        super();
    }

    public RoundDTO(Round round) {
        super(round);
        roundNumber = round.getRoundNumber();
        actionsPerformed = round.getActionsPerformed().stream()
                .map(ActionDTO::new)
                .collect(Collectors.toSet());
        heroes = round.getHeroes().stream()
                .map(HeroDTO::new)
                .collect(Collectors.toSet());
    }

    @Override
    public int compareTo(RoundDTO other) {
        return Integer.compare(roundNumber, other.getRoundNumber());
    }
}
