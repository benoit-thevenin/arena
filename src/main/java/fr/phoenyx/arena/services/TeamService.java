package fr.phoenyx.arena.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.TeamDTO;
import fr.phoenyx.arena.exceptions.TeamException;
import fr.phoenyx.arena.models.Team;
import fr.phoenyx.arena.repositories.TeamRepository;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<TeamDTO> findAll() {
        return teamRepository.findAll().stream()
                .map(TeamDTO::new)
                .collect(Collectors.toList());
    }

    public TeamDTO findById(Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> TeamException.entityNotFound(id));
        return new TeamDTO(team);
    }
}
