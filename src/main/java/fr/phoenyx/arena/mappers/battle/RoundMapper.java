package fr.phoenyx.arena.mappers.battle;

import fr.phoenyx.arena.dtos.battle.RoundDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.battle.Round;

public class RoundMapper implements Mapper<Round, RoundDTO> {

    @Override
    public RoundDTO entityToDto(Round entity) {
        return new RoundDTO(entity);
    }

    @Override
    public Round dtoToEntity(RoundDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }
}
