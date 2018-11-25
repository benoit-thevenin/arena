package fr.phoenyx.arena.controller.guild;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.guild.GuildDTO;
import fr.phoenyx.arena.services.guild.GuildService;

@RestController
public class GuildController {

    @Autowired
    private GuildService guildService;

    @GetMapping("/guilds")
    public List<GuildDTO> getAllGuilds() {
        return guildService.getAllGuilds();
    }
}
