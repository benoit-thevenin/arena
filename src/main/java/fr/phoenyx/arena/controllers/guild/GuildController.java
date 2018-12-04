package fr.phoenyx.arena.controllers.guild;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.guild.GuildDTO;
import fr.phoenyx.arena.services.guild.GuildService;

@RestController
public class GuildController {

    @Autowired
    private GuildService guildService;

    @GetMapping("/guilds")
    public ResponseEntity<List<GuildDTO>> findAll() {
        return new ResponseEntity<>(guildService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/guilds/{id}")
    public ResponseEntity<GuildDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(guildService.findById(id), HttpStatus.OK);
    }
}
