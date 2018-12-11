package fr.phoenyx.arena.mappers.battle;

import fr.phoenyx.arena.dtos.battle.HeroBuildDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.battle.HeroBuild;

public class HeroBuildMapper implements Mapper<HeroBuild, HeroBuildDTO> {

    @Override
    public HeroBuildDTO entityToDto(HeroBuild entity) {
        return new HeroBuildDTO(entity);
    }

    @Override
    public HeroBuild dtoToEntity(HeroBuildDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }
}
