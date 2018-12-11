package fr.phoenyx.arena.controllers.skill;

import static fr.phoenyx.arena.constants.RestConstants.ROOT_STRATEGIES;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.controllers.CrudController;
import fr.phoenyx.arena.dtos.skill.StrategyDTO;
import fr.phoenyx.arena.models.skill.Strategy;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.skill.StrategyService;

@RestController
@RequestMapping(ROOT_STRATEGIES)
public class StrategyController extends CrudController<Strategy, Long, StrategyDTO> {

    @Autowired
    private StrategyService strategyService;

    @Override
    protected CrudService<Strategy, Long, StrategyDTO> getService() {
        return strategyService;
    }
}
