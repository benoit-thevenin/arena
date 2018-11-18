package fr.phoenyx.arena.services.skill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.models.skill.Strategy;
import fr.phoenyx.arena.repositories.skill.StrategyRepository;

@Service
public class StrategyService {

    @Autowired
    private StrategyRepository strategyRepository;

    public List<Strategy> getAllStrategies() {
        return strategyRepository.findAll();
    }
}
