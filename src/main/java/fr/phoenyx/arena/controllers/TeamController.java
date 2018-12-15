package fr.phoenyx.arena.controllers;

import static fr.phoenyx.arena.constants.RestConstants.ROOT_TEAMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.TeamDTO;
import fr.phoenyx.arena.models.Team;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.TeamService;

@RestController
@RequestMapping(ROOT_TEAMS)
public class TeamController extends CrudController<Team, TeamDTO> {

    @Autowired
    private TeamService teamService;

    @Override
    protected CrudService<Team, TeamDTO> getService() {
        return teamService;
    }
}
