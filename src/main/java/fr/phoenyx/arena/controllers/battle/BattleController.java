package fr.phoenyx.arena.controllers.battle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.controllers.CrudController;
import fr.phoenyx.arena.dtos.battle.BattleDTO;
import fr.phoenyx.arena.models.battle.Battle;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.battle.BattleService;

@RestController
@RequestMapping("/battles")
public class BattleController extends CrudController<Battle, Long, BattleDTO> {

    @Autowired
    private BattleService battleService;

    @Override
    protected CrudService<Battle, Long, BattleDTO> getService() {
        return battleService;
    }
}
