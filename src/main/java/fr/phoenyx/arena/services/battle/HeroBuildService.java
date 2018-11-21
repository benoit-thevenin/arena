package fr.phoenyx.arena.services.battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.models.battle.HeroBuild;
import fr.phoenyx.arena.repositories.battle.HeroBuildRepository;

@Service
public class HeroBuildService {

    @Autowired
    private HeroBuildRepository heroBuildRepository;

    public List<HeroBuild> getAllHeroBuilds() {
        return heroBuildRepository.findAll();
    }
}
