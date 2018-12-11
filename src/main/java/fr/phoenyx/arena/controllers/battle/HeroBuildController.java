package fr.phoenyx.arena.controllers.battle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.controllers.CrudController;
import fr.phoenyx.arena.dtos.battle.HeroBuildDTO;
import fr.phoenyx.arena.models.battle.HeroBuild;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.battle.HeroBuildService;

@RestController
@RequestMapping("/hero-builds")
public class HeroBuildController extends CrudController<HeroBuild, Long, HeroBuildDTO> {

    @Autowired
    private HeroBuildService heroBuildService;

    @Override
    protected CrudService<HeroBuild, Long, HeroBuildDTO> getService() {
        return heroBuildService;
    }
}
