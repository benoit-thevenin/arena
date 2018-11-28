package fr.phoenyx.arena.services.skill;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.skill.StrategyDTO;
import fr.phoenyx.arena.exceptions.skill.StrategyException;
import fr.phoenyx.arena.models.skill.Strategy;
import fr.phoenyx.arena.repositories.skill.StrategyRepository;

@Service
public class StrategyService {

    @Autowired
    private StrategyRepository strategyRepository;

    public List<StrategyDTO> findAll() {
        return strategyRepository.findAll().stream()
                .map(StrategyDTO::new)
                .collect(Collectors.toList());
    }

    public StrategyDTO findById(Long id) {
        Strategy strategy = strategyRepository.findById(id)
                .orElseThrow(() -> StrategyException.entityNotFound(id));
        return new StrategyDTO(strategy);
    }
}
