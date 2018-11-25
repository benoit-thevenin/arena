package fr.phoenyx.arena.dtos.skill;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.models.skill.Strategy;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class StrategyDTO extends GenericEntityDTO {

    private String targetPredicate;
    private int priority;
    private boolean buff;

    public StrategyDTO() {
        super();
    }

    public StrategyDTO(Strategy strategy) {
        super(strategy);
        targetPredicate = strategy.getTargetPredicate();
        priority = strategy.getPriority();
        buff = strategy.isBuff();
    }
}
