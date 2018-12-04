package fr.phoenyx.arena.controllers.battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.battle.SheetDTO;
import fr.phoenyx.arena.services.battle.SheetService;

@RestController
public class SheetController {

    @Autowired
    private SheetService sheetService;

    @GetMapping("/sheets")
    public ResponseEntity<List<SheetDTO>> findAll() {
        return new ResponseEntity<>(sheetService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/sheets/{id}")
    public ResponseEntity<SheetDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(sheetService.findById(id), HttpStatus.OK);
    }
}
