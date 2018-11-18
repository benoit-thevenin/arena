package fr.phoenyx.arena.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}
