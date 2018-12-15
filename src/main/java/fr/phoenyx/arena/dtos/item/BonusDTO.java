package fr.phoenyx.arena.dtos.item;

import fr.phoenyx.arena.dtos.CharacteristicDTO;
import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.models.item.Bonus;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BonusDTO extends GenericEntityDTO {

    private CharacteristicDTO characteristic;
    private double rand;

    public BonusDTO() {
        super();
    }

    public BonusDTO(Bonus bonus) {
        super(bonus);
        if (bonus.getCharacteristic() != null) {
            characteristic = new CharacteristicDTO(bonus.getCharacteristic());
        }
        rand = bonus.getRand();
    }
}
