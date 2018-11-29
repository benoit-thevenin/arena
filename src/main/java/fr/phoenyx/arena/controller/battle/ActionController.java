package fr.phoenyx.arena.controller.battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.battle.ActionDTO;
import fr.phoenyx.arena.services.battle.ActionService;

@RestController
public class ActionController {

    @Autowired
    private ActionService actionService;

    @GetMapping("/actions")
    public ResponseEntity<List<ActionDTO>> findAll() {
        return new ResponseEntity<>(actionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/actions/{id}")
    public ResponseEntity<ActionDTO> findById(Long id) {
        return new ResponseEntity<>(actionService.findById(id), HttpStatus.OK);
    }
}
