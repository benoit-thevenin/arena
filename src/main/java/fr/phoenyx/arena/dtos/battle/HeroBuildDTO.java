package fr.phoenyx.arena.dtos.battle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.dtos.item.ItemDTO;
import fr.phoenyx.arena.dtos.skill.ActiveSkillDTO;
import fr.phoenyx.arena.dtos.skill.PassiveSkillDTO;
import fr.phoenyx.arena.models.battle.HeroBuild;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class HeroBuildDTO extends GenericEntityDTO {

    private Set<HeroDTO> heroes = new HashSet<>();
    private int vitality;
    private int strength;
    private int intelligence;
    private int agility;
    private Set<ActiveSkillDTO> activeSkills = new HashSet<>();
    private Set<PassiveSkillDTO> passiveSkills = new HashSet<>();
    private List<ItemDTO> stuff;

    public HeroBuildDTO() {
        super();
    }

    public HeroBuildDTO(HeroBuild heroBuild) {
        super(heroBuild);
        heroes = heroBuild.getHeroes().stream()
                .map(HeroDTO::new)
                .collect(Collectors.toSet());
        vitality = heroBuild.getVitality();
        strength = heroBuild.getStrength();
        intelligence = heroBuild.getIntelligence();
        agility = heroBuild.getAgility();
        activeSkills = heroBuild.getActiveSkills().stream()
                .map(ActiveSkillDTO::new)
                .collect(Collectors.toSet());
        passiveSkills = heroBuild.getPassiveSkills().stream()
                .map(PassiveSkillDTO::new)
                .collect(Collectors.toSet());
        stuff = heroBuild.getStuff().stream()
                .map(ItemDTO::new)
                .collect(Collectors.toList());
    }
}
