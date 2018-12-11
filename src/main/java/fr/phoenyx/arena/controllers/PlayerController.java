package fr.phoenyx.arena.controllers;

import static fr.phoenyx.arena.constants.RestConstants.ROOT_PLAYERS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.PlayerDTO;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.PlayerService;

@RestController
@RequestMapping(ROOT_PLAYERS)
public class PlayerController extends CrudController<Player, Long, PlayerDTO> {

    @Autowired
    private PlayerService playerService;

    @Override
    protected CrudService<Player, Long, PlayerDTO> getService() {
        return playerService;
    }
}
