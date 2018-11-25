package fr.phoenyx.arena.dtos;

import fr.phoenyx.arena.enums.Characteristic;
import lombok.Data;

@Data
public class CharacteristicDTO {

    private String description;
    private boolean primaryCharacteristic;
    private int minPerLevel;
    private int maxPerLevel;
    private double max;

    public CharacteristicDTO() {
        super();
    }

    public CharacteristicDTO(Characteristic characteristic) {
        this();
        description = characteristic.getDescription();
        primaryCharacteristic = characteristic.isPrimaryCharacteristic();
        minPerLevel = characteristic.getMinPerLevel();
        maxPerLevel = characteristic.getMaxPerLevel();
        max = characteristic.getMax();
    }
}
