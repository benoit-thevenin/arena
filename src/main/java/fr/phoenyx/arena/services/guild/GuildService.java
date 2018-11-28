package fr.phoenyx.arena.services.guild;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.guild.GuildDTO;
import fr.phoenyx.arena.exceptions.guild.GuildException;
import fr.phoenyx.arena.models.guild.Guild;
import fr.phoenyx.arena.repositories.guild.GuildRepository;

@Service
public class GuildService {

    @Autowired
    private GuildRepository guildRepository;

    public List<GuildDTO> findAll() {
        return guildRepository.findAll().stream()
                .map(GuildDTO::new)
                .collect(Collectors.toList());
    }

    public GuildDTO findById(Long id) {
        Guild guild = guildRepository.findById(id)
                .orElseThrow(() -> GuildException.entityNotFound(id));
        return new GuildDTO(guild);
    }
}
