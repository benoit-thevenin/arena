package fr.phoenyx.arena.controllers.skill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.skill.StrategyDTO;
import fr.phoenyx.arena.services.skill.StrategyService;

@RestController
public class StrategyController {

    @Autowired
    private StrategyService strategyService;

    @GetMapping("/strategies")
    public ResponseEntity<List<StrategyDTO>> findAll() {
        return new ResponseEntity<>(strategyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/strategies/{id}")
    public ResponseEntity<StrategyDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(strategyService.findById(id), HttpStatus.OK);
    }
}
