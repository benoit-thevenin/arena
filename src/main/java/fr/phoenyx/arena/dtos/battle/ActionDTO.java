package fr.phoenyx.arena.dtos.battle;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.dtos.skill.ActiveSkillDTO;
import fr.phoenyx.arena.models.battle.Action;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ActionDTO extends GenericEntityDTO implements Comparable<ActionDTO> {

    private int actionOrder;
    private HeroDTO caster;
    private ActiveSkillDTO skill;
    private Set<HeroDTO> targets = new HashSet<>();
    private double rand;

    public ActionDTO() {
        super();
    }

    public ActionDTO(Action action) {
        super(action);
        actionOrder = action.getActionOrder();
        if (action.getCaster() != null) {
            caster = new HeroDTO(action.getCaster());
        }
        if (action.getSkill() != null) {
            skill = new ActiveSkillDTO(action.getSkill());
        }
        targets = action.getTargets().stream()
                .map(HeroDTO::new)
                .collect(Collectors.toSet());
        rand = action.getRand();
    }

    @Override
    public int compareTo(ActionDTO other) {
        return Integer.compare(actionOrder, other.getActionOrder());
    }
}
