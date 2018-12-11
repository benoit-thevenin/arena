package fr.phoenyx.arena.services.guild;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.guild.GuildDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.guild.GuildMapper;
import fr.phoenyx.arena.models.guild.Guild;
import fr.phoenyx.arena.repositories.guild.GuildRepository;
import fr.phoenyx.arena.services.CrudService;

@Service
public class GuildService extends CrudService<Guild, Long, GuildDTO> {

    @Autowired
    private GuildRepository guildRepository;

    @Override
    protected JpaRepository<Guild, Long> getRepository() {
        return guildRepository;
    }

    @Override
    protected Mapper<Guild, GuildDTO> getMapper() {
        return new GuildMapper();
    }

    @Override
    protected Class<Guild> getConcernedClass() {
        return Guild.class;
    }
}
