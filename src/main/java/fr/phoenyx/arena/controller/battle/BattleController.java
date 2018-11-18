package fr.phoenyx.arena.controller.battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.models.battle.Battle;
import fr.phoenyx.arena.services.battle.BattleService;

@RestController
public class BattleController {

    @Autowired
    private BattleService battleService;

    @GetMapping("/battles")
    public List<Battle> getAllBattles() {
        return battleService.getAllBattles();
    }
}
