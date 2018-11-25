package fr.phoenyx.arena.dtos.item;

import fr.phoenyx.arena.enums.item.Power;
import lombok.Data;

@Data
public class PowerDTO {

    private String name;
    private String description;
    private int value;

    public PowerDTO() {
        super();
    }

    public PowerDTO(Power power) {
        this();
        name = power.getName();
        description = power.getDescription();
        value = power.getValue();
    }
}
