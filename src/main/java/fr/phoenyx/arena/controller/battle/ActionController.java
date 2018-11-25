package fr.phoenyx.arena.controller.battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.battle.ActionDTO;
import fr.phoenyx.arena.services.battle.ActionService;

@RestController
public class ActionController {

    @Autowired
    private ActionService actionService;

    @GetMapping("/actions")
    public List<ActionDTO> getAllActions() {
        return actionService.getAllActions();
    }
}
