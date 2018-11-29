package fr.phoenyx.arena.controller.battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.battle.RoundDTO;
import fr.phoenyx.arena.services.battle.RoundService;

@RestController
public class RoundController {

    @Autowired
    private RoundService roundService;

    @GetMapping("/rounds")
    public ResponseEntity<List<RoundDTO>> findAll() {
        return new ResponseEntity<>(roundService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/rounds/{id}")
    public ResponseEntity<RoundDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(roundService.findById(id), HttpStatus.OK);
    }
}
