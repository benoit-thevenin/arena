package fr.phoenyx.arena.mappers.battle;

import fr.phoenyx.arena.dtos.battle.BuildDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.battle.Build;

public class BuildMapper implements Mapper<Build, BuildDTO> {

    @Override
    public BuildDTO entityToDto(Build entity) {
        return new BuildDTO(entity);
    }
}
