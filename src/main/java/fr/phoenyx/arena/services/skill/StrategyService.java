package fr.phoenyx.arena.services.skill;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.skill.StrategyDTO;
import fr.phoenyx.arena.repositories.skill.StrategyRepository;

@Service
public class StrategyService {

    @Autowired
    private StrategyRepository strategyRepository;

    public List<StrategyDTO> getAllStrategies() {
        return strategyRepository.findAll().stream()
                .map(strategy -> new StrategyDTO(strategy))
                .collect(Collectors.toList());
    }
}
