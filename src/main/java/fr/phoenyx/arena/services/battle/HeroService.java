package fr.phoenyx.arena.services.battle;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.battle.HeroDTO;
import fr.phoenyx.arena.repositories.battle.HeroRepository;

@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    public List<HeroDTO> getAllHeroes() {
        return heroRepository.findAll().stream()
                .map(HeroDTO::new)
                .collect(Collectors.toList());
    }
}
