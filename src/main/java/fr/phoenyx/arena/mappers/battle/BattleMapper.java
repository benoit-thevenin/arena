package fr.phoenyx.arena.mappers.battle;

import fr.phoenyx.arena.dtos.battle.BattleDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.battle.Battle;

public class BattleMapper implements Mapper<Battle, BattleDTO> {

    @Override
    public BattleDTO entityToDto(Battle entity) {
        return new BattleDTO(entity);
    }
}
