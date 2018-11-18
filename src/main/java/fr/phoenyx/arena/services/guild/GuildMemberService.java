package fr.phoenyx.arena.services.guild;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.models.guild.GuildMember;
import fr.phoenyx.arena.repositories.guild.GuildMemberRepository;

@Service
public class GuildMemberService {

    @Autowired
    private GuildMemberRepository guildMemberRepository;

    public List<GuildMember> getAllGuildMembers() {
        return guildMemberRepository.findAll();
    }
}
