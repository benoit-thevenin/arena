package fr.phoenyx.arena.mappers;

import fr.phoenyx.arena.dtos.BuildDTO;
import fr.phoenyx.arena.models.Build;

public class BuildMapper implements Mapper<Build, BuildDTO> {

    @Override
    public BuildDTO entityToDto(Build entity) {
        return new BuildDTO(entity);
    }

    @Override
    public Build dtoToEntity(BuildDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }
}