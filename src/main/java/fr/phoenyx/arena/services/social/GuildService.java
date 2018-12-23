package fr.phoenyx.arena.services.social;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.social.GuildDTO;
import fr.phoenyx.arena.exceptions.BadRequestException;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.social.GuildMapper;
import fr.phoenyx.arena.models.social.Guild;
import fr.phoenyx.arena.repositories.social.GuildRepository;
import fr.phoenyx.arena.services.CrudService;

@Service
public class GuildService extends CrudService<Guild, GuildDTO> {

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

    @Override
    public GuildDTO create(GuildDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    public GuildDTO update(GuildDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }
}
