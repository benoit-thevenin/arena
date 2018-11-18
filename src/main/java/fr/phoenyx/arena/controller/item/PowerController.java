package fr.phoenyx.arena.controller.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.models.item.Power;
import fr.phoenyx.arena.services.item.PowerService;

@RestController
public class PowerController {

    @Autowired
    private PowerService powerService;

    @GetMapping("/powers")
    public List<Power> getAllPowers() {
        return powerService.getAllPowers();
    }
}
