package fr.phoenyx.arena.mappers.social;

import fr.phoenyx.arena.dtos.social.TeamDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.social.Team;

public class TeamMapper implements Mapper<Team, TeamDTO> {

    @Override
    public TeamDTO entityToDto(Team entity) {
        return new TeamDTO(entity);
    }
}
