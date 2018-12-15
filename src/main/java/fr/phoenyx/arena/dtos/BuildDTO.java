package fr.phoenyx.arena.dtos;

import java.util.ArrayList;
import java.util.HashSet;
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
    private Set<ActiveSkillDTO> activeSkills = new HashSet<>();
    private Set<PassiveSkillDTO> passiveSkills = new HashSet<>();
    private List<ItemDTO> stuff = new ArrayList<>();
    private String specialization;
    private Set<TypeDTO> types = new HashSet<>();

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
                .collect(Collectors.toSet());
        passiveSkills = build.getPassiveSkills().stream()
                .map(PassiveSkillDTO::new)
                .collect(Collectors.toSet());
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
