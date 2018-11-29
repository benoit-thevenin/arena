package fr.phoenyx.arena.controller.battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.battle.HeroDTO;
import fr.phoenyx.arena.services.battle.HeroService;

@RestController
public class HeroController {

    @Autowired
    private HeroService heroService;

    @GetMapping("/heroes")
    public ResponseEntity<List<HeroDTO>> findAll() {
        return new ResponseEntity<>(heroService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/heroes/{id}")
    public ResponseEntity<HeroDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(heroService.findById(id), HttpStatus.OK);
    }
}
