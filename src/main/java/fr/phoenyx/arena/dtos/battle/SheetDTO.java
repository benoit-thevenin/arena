package fr.phoenyx.arena.dtos.battle;

import java.util.List;
import java.util.stream.Collectors;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.dtos.skill.EffectDTO;
import fr.phoenyx.arena.models.battle.Sheet;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SheetDTO extends GenericEntityDTO {

    private int initHealth;
    private int initMana;
    private int strength;
    private int agility;
    private int intelligence;
    private int currentHealth;
    private int currentMana;
    private List<EffectDTO> effects;

    public SheetDTO() {
        super();
    }

    public SheetDTO(Sheet sheet) {
        super(sheet);
        initHealth = sheet.getInitHealth();
        initMana = sheet.getInitMana();
        strength = sheet.getStrength();
        agility = sheet.getAgility();
        intelligence = sheet.getIntelligence();
        currentHealth = sheet.getCurrentHealth();
        currentMana = sheet.getCurrentMana();
        effects = sheet.getEffects().stream()
                .map(effect -> new EffectDTO(effect))
                .collect(Collectors.toList());
    }
}
