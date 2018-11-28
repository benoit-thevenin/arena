package fr.phoenyx.arena.controller.battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.battle.RoundDTO;
import fr.phoenyx.arena.services.battle.RoundService;

@RestController
public class RoundController {

    @Autowired
    private RoundService roundService;

    @GetMapping("/rounds")
    public List<RoundDTO> findAll() {
        return roundService.findAll();
    }

    @GetMapping("/rounds/{id}")
    public RoundDTO findById(@PathVariable Long id) {
        return roundService.findById(id);
    }
}
