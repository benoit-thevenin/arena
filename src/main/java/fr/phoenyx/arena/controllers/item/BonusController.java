package fr.phoenyx.arena.controllers.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.controllers.CrudController;
import fr.phoenyx.arena.dtos.item.BonusDTO;
import fr.phoenyx.arena.models.item.Bonus;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.item.BonusService;

@RestController
@RequestMapping("/bonuses")
public class BonusController extends CrudController<Bonus, Long, BonusDTO> {

    @Autowired
    private BonusService bonusService;

    @Override
    protected CrudService<Bonus, Long, BonusDTO> getService() {
        return bonusService;
    }
}
