package fr.phoenyx.arena.controllers.battle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.controllers.CrudController;
import fr.phoenyx.arena.dtos.battle.RoundDTO;
import fr.phoenyx.arena.models.battle.Round;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.battle.RoundService;

@RestController
@RequestMapping("/rounds")
public class RoundController extends CrudController<Round, Long, RoundDTO> {

    @Autowired
    private RoundService roundService;

    @Override
    protected CrudService<Round, Long, RoundDTO> getService() {
        return roundService;
    }
}
