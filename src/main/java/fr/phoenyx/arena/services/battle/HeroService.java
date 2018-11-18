package fr.phoenyx.arena.services.battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.phoenyx.arena.models.battle.Hero;
import fr.phoenyx.arena.repositories.battle.HeroRepository;
import org.springframework.stereotype.Service;

@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    public List<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }
}
