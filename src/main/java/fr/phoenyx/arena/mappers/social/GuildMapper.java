package fr.phoenyx.arena.mappers.social;

import fr.phoenyx.arena.dtos.social.GuildDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.social.Guild;

public class GuildMapper implements Mapper<Guild, GuildDTO> {

    @Override
    public GuildDTO entityToDto(Guild entity) {
        return new GuildDTO(entity);
    }
}
