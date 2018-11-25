package fr.phoenyx.arena.services.guild;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.guild.GuildDTO;
import fr.phoenyx.arena.repositories.guild.GuildRepository;

@Service
public class GuildService {

    @Autowired
    private GuildRepository guildRepository;

    public List<GuildDTO> getAllGuilds() {
        return guildRepository.findAll().stream()
                .map(guild -> new GuildDTO(guild))
                .collect(Collectors.toList());
    }
}
