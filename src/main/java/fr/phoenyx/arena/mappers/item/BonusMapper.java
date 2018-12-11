package fr.phoenyx.arena.mappers.item;

import fr.phoenyx.arena.dtos.item.BonusDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.item.Bonus;

public class BonusMapper implements Mapper<Bonus, BonusDTO> {

    @Override
    public BonusDTO entityToDto(Bonus entity) {
        return new BonusDTO(entity);
    }

    @Override
    public Bonus dtoToEntity(BonusDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }
}
