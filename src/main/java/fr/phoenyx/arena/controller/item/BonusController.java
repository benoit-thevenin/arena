package fr.phoenyx.arena.controller.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.item.BonusDTO;
import fr.phoenyx.arena.services.item.BonusService;

@RestController
public class BonusController {

    @Autowired
    private BonusService bonusService;

    @GetMapping("/bonuses")
    public ResponseEntity<List<BonusDTO>> findAll() {
        return new ResponseEntity<>(bonusService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/bonuses/{id}")
    public ResponseEntity<BonusDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(bonusService.findById(id), HttpStatus.OK);
    }
}
