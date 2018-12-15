package fr.phoenyx.arena.controllers.battle;

import static fr.phoenyx.arena.constants.RestConstants.ROOT_HEROES;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.controllers.CrudController;
import fr.phoenyx.arena.dtos.battle.HeroDTO;
import fr.phoenyx.arena.models.battle.Hero;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.battle.HeroService;

@RestController
@RequestMapping(ROOT_HEROES)
public class HeroController extends CrudController<Hero, HeroDTO> {

    @Autowired
    private HeroService heroService;

    @Override
    protected CrudService<Hero, HeroDTO> getService() {
        return heroService;
    }
}
