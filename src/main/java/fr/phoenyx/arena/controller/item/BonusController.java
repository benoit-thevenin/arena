package fr.phoenyx.arena.controller.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.models.item.Bonus;
import fr.phoenyx.arena.services.item.BonusService;

@RestController
public class BonusController {

    @Autowired
    private BonusService bonusService;

    @GetMapping("/bonuses")
    public List<Bonus> getAllBonuses() {
        return bonusService.getAllBonuses();
    }
}
