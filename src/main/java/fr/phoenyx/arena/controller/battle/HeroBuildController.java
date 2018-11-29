package fr.phoenyx.arena.controller.battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.battle.HeroBuildDTO;
import fr.phoenyx.arena.services.battle.HeroBuildService;

@RestController
public class HeroBuildController {

    @Autowired
    private HeroBuildService heroBuildService;

    @GetMapping("/hero-builds")
    public ResponseEntity<List<HeroBuildDTO>> findAll() {
        return new ResponseEntity<>(heroBuildService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/hero-builds/{id}")
    public ResponseEntity<HeroBuildDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(heroBuildService.findById(id), HttpStatus.OK);
    }
}
