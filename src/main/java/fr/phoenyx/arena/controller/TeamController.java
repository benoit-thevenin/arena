package fr.phoenyx.arena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.TeamDTO;
import fr.phoenyx.arena.services.TeamService;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/teams")
    public List<TeamDTO> findAll() {
        return teamService.getAllTeams();
    }

    @GetMapping("/teams/{id}")
    public TeamDTO findTeamById(@PathVariable Long id) {
        return teamService.findById(id);
    }
}
