package fr.phoenyx.arena.controller.battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.battle.HeroBuildDTO;
import fr.phoenyx.arena.services.battle.HeroBuildService;

@RestController
public class HeroBuildController {

    @Autowired
    private HeroBuildService heroBuildService;

    @GetMapping("/hero-builds")
    public List<HeroBuildDTO> getAllHeroBuilds() {
        return heroBuildService.getAllHeroBuilds();
    }
}
