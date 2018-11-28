package fr.phoenyx.arena.services.battle;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.battle.HeroDTO;
import fr.phoenyx.arena.exceptions.battle.HeroException;
import fr.phoenyx.arena.models.battle.Hero;
import fr.phoenyx.arena.repositories.battle.HeroRepository;

@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    public List<HeroDTO> findAll() {
        return heroRepository.findAll().stream()
                .map(HeroDTO::new)
                .collect(Collectors.toList());
    }

    public HeroDTO findById(Long id) {
        Hero hero = heroRepository.findById(id)
                .orElseThrow(() -> HeroException.entityNotFound(id));
        return new HeroDTO(hero);
    }
}
