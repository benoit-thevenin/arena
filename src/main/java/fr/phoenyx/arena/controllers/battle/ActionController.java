package fr.phoenyx.arena.controllers.battle;

import static fr.phoenyx.arena.constants.RestConstants.ROOT_ACTIONS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.controllers.CrudController;
import fr.phoenyx.arena.dtos.battle.ActionDTO;
import fr.phoenyx.arena.models.battle.Action;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.battle.ActionService;

@RestController
@RequestMapping(ROOT_ACTIONS)
public class ActionController extends CrudController<Action, Long, ActionDTO> {

    @Autowired
    private ActionService actionService;

    @Override
    protected CrudService<Action, Long, ActionDTO> getService() {
        return actionService;
    }
}
