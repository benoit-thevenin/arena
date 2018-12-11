package fr.phoenyx.arena.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.TeamDTO;
import fr.phoenyx.arena.models.Team;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.TeamService;

@RestController
@RequestMapping("/teams")
public class TeamController extends CrudController<Team, Long, TeamDTO> {

    @Autowired
    private TeamService teamService;

    @Override
    protected CrudService<Team, Long, TeamDTO> getService() {
        return teamService;
    }
}
