package fr.phoenyx.arena.mappers;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.models.GenericEntity;

public interface Mapper<E extends GenericEntity, D extends GenericEntityDTO> {

    public D entityToDto(E entity);
}
