package fr.phoenyx.arena.controller.battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.battle.BattleDTO;
import fr.phoenyx.arena.services.battle.BattleService;

@RestController
public class BattleController {

    @Autowired
    private BattleService battleService;

    @GetMapping("/battles")
    public List<BattleDTO> getAllBattles() {
        return battleService.getAllBattles();
    }
}
