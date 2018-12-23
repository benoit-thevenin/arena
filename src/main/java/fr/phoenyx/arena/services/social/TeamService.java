package fr.phoenyx.arena.services.social;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.social.TeamDTO;
import fr.phoenyx.arena.exceptions.BadRequestException;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.social.TeamMapper;
import fr.phoenyx.arena.models.social.Team;
import fr.phoenyx.arena.repositories.social.TeamRepository;
import fr.phoenyx.arena.services.CrudService;

@Service
public class TeamService extends CrudService<Team, TeamDTO> {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    protected JpaRepository<Team, Long> getRepository() {
        return teamRepository;
    }

    @Override
    protected Mapper<Team, TeamDTO> getMapper() {
        return new TeamMapper();
    }

    @Override
    protected Class<Team> getConcernedClass() {
        return Team.class;
    }

    @Override
    public TeamDTO create(TeamDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    public TeamDTO update(TeamDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }
}
