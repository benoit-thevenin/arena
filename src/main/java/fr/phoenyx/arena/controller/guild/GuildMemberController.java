package fr.phoenyx.arena.controller.guild;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.models.guild.GuildMember;
import fr.phoenyx.arena.services.guild.GuildMemberService;

@RestController
public class GuildMemberController {

    @Autowired
    private GuildMemberService guildMemberService;

    @GetMapping("/guild-members")
    public List<GuildMember> getAllGuildMembers() {
        return guildMemberService.getAllGuildMembers();
    }
}
