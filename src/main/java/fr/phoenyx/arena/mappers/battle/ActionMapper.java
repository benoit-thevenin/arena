package fr.phoenyx.arena.mappers.battle;

import fr.phoenyx.arena.dtos.battle.ActionDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.battle.Action;

public class ActionMapper implements Mapper<Action, ActionDTO> {

    @Override
    public ActionDTO entityToDto(Action entity) {
        return new ActionDTO(entity);
    }
}
