package fr.phoenyx.arena.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.TeamDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.TeamMapper;
import fr.phoenyx.arena.models.Team;
import fr.phoenyx.arena.repositories.TeamRepository;

@Service
public class TeamService extends CrudService<Team, Long, TeamDTO> {

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
}
