package fr.phoenyx.arena.controllers.social;

import static fr.phoenyx.arena.constants.RestConstants.ROOT_PLAYERS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.controllers.CrudController;
import fr.phoenyx.arena.dtos.social.PlayerDTO;
import fr.phoenyx.arena.models.social.Player;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.social.PlayerService;

@RestController
@RequestMapping(ROOT_PLAYERS)
public class PlayerController extends CrudController<Player, PlayerDTO> {

    @Autowired
    private PlayerService playerService;

    @Override
    protected CrudService<Player, PlayerDTO> getService() {
        return playerService;
    }
}
