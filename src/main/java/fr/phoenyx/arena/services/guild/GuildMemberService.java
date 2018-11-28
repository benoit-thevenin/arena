package fr.phoenyx.arena.services.guild;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.guild.GuildMemberDTO;
import fr.phoenyx.arena.exceptions.guild.GuildMemberException;
import fr.phoenyx.arena.models.guild.GuildMember;
import fr.phoenyx.arena.repositories.guild.GuildMemberRepository;

@Service
public class GuildMemberService {

    @Autowired
    private GuildMemberRepository guildMemberRepository;

    public List<GuildMemberDTO> findAll() {
        return guildMemberRepository.findAll().stream()
                .map(guildMember -> new GuildMemberDTO(guildMember, Optional.empty()))
                .collect(Collectors.toList());
    }

    public GuildMemberDTO findById(Long id) {
        GuildMember guildMember = guildMemberRepository.findById(id)
                .orElseThrow(() -> GuildMemberException.entityNotFound(id));
        return new GuildMemberDTO(guildMember, Optional.empty());
    }
}
