package fr.phoenyx.arena.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.models.Team;
import fr.phoenyx.arena.repositories.TeamRepository;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}
