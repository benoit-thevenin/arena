package fr.phoenyx.arena.controllers.guild;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.controllers.CrudController;
import fr.phoenyx.arena.dtos.guild.GuildDTO;
import fr.phoenyx.arena.models.guild.Guild;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.guild.GuildService;

@RestController
@RequestMapping("/guilds")
public class GuildController extends CrudController<Guild, Long, GuildDTO> {

    @Autowired
    private GuildService guildService;

    @Override
    protected CrudService<Guild, Long, GuildDTO> getService() {
        return guildService;
    }
}
