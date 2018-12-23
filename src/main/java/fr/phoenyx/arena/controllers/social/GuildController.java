package fr.phoenyx.arena.controllers.social;

import static fr.phoenyx.arena.constants.RestConstants.ROOT_GUILDS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.controllers.CrudController;
import fr.phoenyx.arena.dtos.social.GuildDTO;
import fr.phoenyx.arena.models.social.Guild;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.social.GuildService;

@RestController
@RequestMapping(ROOT_GUILDS)
public class GuildController extends CrudController<Guild, GuildDTO> {

    @Autowired
    private GuildService guildService;

    @Override
    protected CrudService<Guild, GuildDTO> getService() {
        return guildService;
    }
}
