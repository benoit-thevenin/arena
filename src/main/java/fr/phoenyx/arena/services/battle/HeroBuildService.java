package fr.phoenyx.arena.services.battle;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.battle.HeroBuildDTO;
import fr.phoenyx.arena.repositories.battle.HeroBuildRepository;

@Service
public class HeroBuildService {

    @Autowired
    private HeroBuildRepository heroBuildRepository;

    public List<HeroBuildDTO> getAllHeroBuilds() {
        return heroBuildRepository.findAll().stream()
                .map(heroBuild -> new HeroBuildDTO(heroBuild))
                .collect(Collectors.toList());
    }
}
