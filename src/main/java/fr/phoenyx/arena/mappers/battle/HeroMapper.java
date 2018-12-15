package fr.phoenyx.arena.mappers.battle;

import fr.phoenyx.arena.dtos.battle.HeroDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.battle.Hero;

public class HeroMapper implements Mapper<Hero, HeroDTO> {

    @Override
    public HeroDTO entityToDto(Hero entity) {
        return new HeroDTO(entity);
    }
}
