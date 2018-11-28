package fr.phoenyx.arena.services.battle;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.battle.HeroBuildDTO;
import fr.phoenyx.arena.exceptions.battle.HeroBuildException;
import fr.phoenyx.arena.models.battle.HeroBuild;
import fr.phoenyx.arena.repositories.battle.HeroBuildRepository;

@Service
public class HeroBuildService {

    @Autowired
    private HeroBuildRepository heroBuildRepository;

    public List<HeroBuildDTO> findAll() {
        return heroBuildRepository.findAll().stream()
                .map(HeroBuildDTO::new)
                .collect(Collectors.toList());
    }

    public HeroBuildDTO findById(Long id) {
        HeroBuild heroBuild = heroBuildRepository.findById(id)
                .orElseThrow(() -> HeroBuildException.entityNotFound(id));
        return new HeroBuildDTO(heroBuild);
    }
}
