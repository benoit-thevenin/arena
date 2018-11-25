package fr.phoenyx.arena.controller.skill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.skill.StrategyDTO;
import fr.phoenyx.arena.services.skill.StrategyService;

@RestController
public class StrategyController {

    @Autowired
    private StrategyService strategyService;

    @GetMapping("/strategies")
    public List<StrategyDTO> getAllStrategies() {
        return strategyService.getAllStrategies();
    }
}
