package fr.phoenyx.arena.dtos.battle;

import java.util.List;
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

    private List<HeroDTO> heroes;
    private int vitality;
    private int strength;
    private int intelligence;
    private int agility;
    private List<ActiveSkillDTO> activeSkills;
    private List<PassiveSkillDTO> passiveSkills;
    private List<ItemDTO> stuff;

    public HeroBuildDTO() {
        super();
    }

    public HeroBuildDTO(HeroBuild heroBuild) {
        super(heroBuild);
        heroes = heroBuild.getHeroes().stream()
                .map(hero -> new HeroDTO(hero))
                .collect(Collectors.toList());
        vitality = heroBuild.getVitality();
        strength = heroBuild.getStrength();
        intelligence = heroBuild.getIntelligence();
        agility = heroBuild.getAgility();
        activeSkills = heroBuild.getActiveSkills().stream()
                .map(activeSkill -> new ActiveSkillDTO(activeSkill))
                .collect(Collectors.toList());
        passiveSkills = heroBuild.getPassiveSkills().stream()
                .map(passiveSkill -> new PassiveSkillDTO(passiveSkill))
                .collect(Collectors.toList());
        stuff = heroBuild.getStuff().stream()
                .map(item -> new ItemDTO(item))
                .collect(Collectors.toList());
    }
}
