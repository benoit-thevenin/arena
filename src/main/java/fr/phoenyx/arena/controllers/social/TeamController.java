package fr.phoenyx.arena.controllers.social;

import static fr.phoenyx.arena.constants.RestConstants.ROOT_TEAMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.controllers.CrudController;
import fr.phoenyx.arena.dtos.social.TeamDTO;
import fr.phoenyx.arena.models.social.Team;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.social.TeamService;

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
