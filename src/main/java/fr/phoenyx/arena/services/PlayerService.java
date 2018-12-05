package fr.phoenyx.arena.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.PlayerDTO;
import fr.phoenyx.arena.exceptions.PlayerException;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.repositories.PlayerRepository;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<PlayerDTO> findAll() {
        return playerRepository.findAll().stream()
                .map(PlayerDTO::new)
                .collect(Collectors.toList());
    }

    public PlayerDTO findById(Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> PlayerException.entityNotFound(id));
        return new PlayerDTO(player);
    }

    public PlayerDTO findByEmail(String email) {
        Player player = playerRepository.findByEmail(email)
                .orElseThrow(() -> PlayerException.entityNotFound(email));
        return new PlayerDTO(player);
    }
}
