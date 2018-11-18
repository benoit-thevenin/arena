package fr.phoenyx.arena.controller.battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.models.battle.Hero;
import fr.phoenyx.arena.services.battle.HeroService;

@RestController
public class HeroController {

    @Autowired
    private HeroService heroService;

    @GetMapping("/heroes")
    public List<Hero> getAllHeroes() {
        return heroService.getAllHeroes();
    }
}
