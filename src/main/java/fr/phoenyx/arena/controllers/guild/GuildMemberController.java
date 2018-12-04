package fr.phoenyx.arena.controllers.guild;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.guild.GuildMemberDTO;
import fr.phoenyx.arena.services.guild.GuildMemberService;

@RestController
public class GuildMemberController {

    @Autowired
    private GuildMemberService guildMemberService;

    @GetMapping("/guild-members")
    public ResponseEntity<List<GuildMemberDTO>> findAll() {
        return new ResponseEntity<>(guildMemberService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/guild-members/{id}")
    public ResponseEntity<GuildMemberDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(guildMemberService.findById(id), HttpStatus.OK);
    }
}
