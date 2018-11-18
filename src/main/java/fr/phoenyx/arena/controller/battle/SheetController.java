package fr.phoenyx.arena.controller.battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.models.battle.Sheet;
import fr.phoenyx.arena.services.battle.SheetService;

@RestController
public class SheetController {

    @Autowired
    private SheetService sheetService;

    @GetMapping("/sheets")
    public List<Sheet> getAllSheets() {
        return sheetService.getAllSheets();
    }
}
