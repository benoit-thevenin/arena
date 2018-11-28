package fr.phoenyx.arena.controller.battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.battle.HeroDTO;
import fr.phoenyx.arena.services.battle.HeroService;

@RestController
public class HeroController {

    @Autowired
    private HeroService heroService;

    @GetMapping("/heroes")
    public List<HeroDTO> findAll() {
        return heroService.findAll();
    }

    @GetMapping("/heroes/{id}")
    public HeroDTO findById(@PathVariable Long id) {
        return heroService.findById(id);
    }
}
