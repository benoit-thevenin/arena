package fr.phoenyx.arena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.PlayerDTO;
import fr.phoenyx.arena.services.PlayerService;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public List<PlayerDTO> findAll() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/players/{id}")
    public PlayerDTO findById(@PathVariable Long id) {
        return playerService.findById(id);
    }
}
