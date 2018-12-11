package fr.phoenyx.arena.mappers.battle;

import fr.phoenyx.arena.dtos.battle.SheetDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.battle.Sheet;

public class SheetMapper implements Mapper<Sheet, SheetDTO> {

    @Override
    public SheetDTO entityToDto(Sheet entity) {
        return new SheetDTO(entity);
    }

    @Override
    public Sheet dtoToEntity(SheetDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }
}
