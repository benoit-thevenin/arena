package fr.phoenyx.arena.mappers.guild;

import fr.phoenyx.arena.dtos.guild.GuildDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.guild.Guild;

public class GuildMapper implements Mapper<Guild, GuildDTO> {

    @Override
    public GuildDTO entityToDto(Guild entity) {
        return new GuildDTO(entity);
    }
}
