package fr.phoenyx.arena.dtos;

import fr.phoenyx.arena.models.GenericEntity;
import lombok.Data;

@Data
public abstract class GenericEntityDTO {

    protected long id;

    public GenericEntityDTO() {
        super();
    }

    public GenericEntityDTO(GenericEntity genericEntity) {
        this();
        id = genericEntity.getId();
    }
}
