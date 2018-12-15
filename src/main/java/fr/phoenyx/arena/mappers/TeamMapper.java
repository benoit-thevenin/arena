package fr.phoenyx.arena.mappers;

import fr.phoenyx.arena.dtos.TeamDTO;
import fr.phoenyx.arena.models.Team;

public class TeamMapper implements Mapper<Team, TeamDTO> {

    @Override
    public TeamDTO entityToDto(Team entity) {
        return new TeamDTO(entity);
    }
}
