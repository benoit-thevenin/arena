package fr.phoenyx.arena.services.guild;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.models.guild.Guild;
import fr.phoenyx.arena.repositories.guild.GuildRepository;

@Service
public class GuildService {

    @Autowired
    private GuildRepository guildRepository;

    public List<Guild> getAllGuilds() {
        return guildRepository.findAll();
    }
}
