package fr.phoenyx.arena.dtos;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import fr.phoenyx.arena.dtos.item.ItemDTO;
import fr.phoenyx.arena.dtos.skill.ActiveSkillDTO;
import fr.phoenyx.arena.dtos.skill.PassiveSkillDTO;
import fr.phoenyx.arena.models.Build;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BuildDTO extends GenericEntityDTO {

    private int vitality;
    private int strength;
    private int intelligence;
    private int agility;
    private List<ActiveSkillDTO> activeSkills;
    private List<PassiveSkillDTO> passiveSkills;
    private List<ItemDTO> stuff;
    private String specialization;
    private Set<TypeDTO> types;

    public BuildDTO() {
        super();
    }

    public BuildDTO(Build build) {
        super(build);
        vitality = build.getVitality();
        strength = build.getStrength();
        intelligence = build.getIntelligence();
        agility = build.getAgility();
        activeSkills = build.getActiveSkills().stream()
                .map(ActiveSkillDTO::new)
                .collect(Collectors.toList());
        passiveSkills = build.getPassiveSkills().stream()
                .map(PassiveSkillDTO::new)
                .collect(Collectors.toList());
        stuff = build.getStuff().stream()
                .map(ItemDTO::new)
                .collect(Collectors.toList());
        if (build.getSpecialization() != null) {
            specialization = build.getSpecialization().getDescription();
        }
        types = build.getTypes().stream()
                .map(TypeDTO::new)
                .collect(Collectors.toSet());
    }
}
