package fr.phoenyx.arena.controller.battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.models.battle.Action;
import fr.phoenyx.arena.services.battle.ActionService;

@RestController
public class ActionController {

    @Autowired
    private ActionService actionService;

    @GetMapping("/actions")
    public List<Action> getAllActions() {
        return actionService.getAllActions();
    }
}