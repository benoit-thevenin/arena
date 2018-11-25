package fr.phoenyx.arena.dtos.item;

import fr.phoenyx.arena.enums.item.Rarity;
import lombok.Data;

@Data
public class RarityDTO {

    private String description;
    private int numberOfAffixes;

    public RarityDTO() {
        super();
    }

    public RarityDTO(Rarity rarity) {
        this();
        description = rarity.getDescription();
        numberOfAffixes = rarity.getNumberOfAffixes();
    }
}
