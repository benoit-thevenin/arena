package fr.phoenyx.arena.mappers.skill;

import fr.phoenyx.arena.dtos.skill.StrategyDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.skill.Strategy;

public class StrategyMapper implements Mapper<Strategy, StrategyDTO> {

    @Override
    public StrategyDTO entityToDto(Strategy entity) {
        return new StrategyDTO(entity);
    }
}
