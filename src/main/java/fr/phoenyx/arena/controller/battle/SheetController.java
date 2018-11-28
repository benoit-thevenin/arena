package fr.phoenyx.arena.controller.battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<SheetDTO> findAll() {
        return sheetService.findAll();
    }

    @GetMapping("/sheets/{id}")
    public SheetDTO findById(@PathVariable Long id) {
        return sheetService.findById(id);
    }
}
