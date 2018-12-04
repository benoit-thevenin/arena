package fr.phoenyx.arena.controllers.skill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.skill.ActiveSkillDTO;
import fr.phoenyx.arena.services.skill.ActiveSkillService;

@RestController
public class ActiveSkillController {

    @Autowired
    private ActiveSkillService activeSkillService;

    @GetMapping("/active-skills")
    public ResponseEntity<List<ActiveSkillDTO>> findAll() {
        return new ResponseEntity<>(activeSkillService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/active-skills/{id}")
    public ResponseEntity<ActiveSkillDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(activeSkillService.findById(id), HttpStatus.OK);
    }
}
