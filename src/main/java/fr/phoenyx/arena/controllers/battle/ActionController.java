package fr.phoenyx.arena.controllers.battle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.controllers.CrudController;
import fr.phoenyx.arena.dtos.battle.ActionDTO;
import fr.phoenyx.arena.models.battle.Action;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.battle.ActionService;

@RestController
@RequestMapping("/actions")
public class ActionController extends CrudController<Action, Long, ActionDTO> {

    @Autowired
    private ActionService actionService;

    @Override
    protected CrudService<Action, Long, ActionDTO> getService() {
        return actionService;
    }
}
