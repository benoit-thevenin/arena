package fr.phoenyx.arena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.models.Team;
import fr.phoenyx.arena.services.TeamService;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }
}
