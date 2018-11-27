package fr.phoenyx.arena.services.battle;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.battle.RoundDTO;
import fr.phoenyx.arena.repositories.battle.RoundRepository;

@Service
public class RoundService {

    @Autowired
    private RoundRepository roundRepository;

    public List<RoundDTO> getAllRounds() {
        return roundRepository.findAll().stream()
                .map(RoundDTO::new)
                .collect(Collectors.toList());
    }
}
