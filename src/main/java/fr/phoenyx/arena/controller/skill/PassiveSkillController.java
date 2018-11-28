package fr.phoenyx.arena.controller.skill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.skill.PassiveSkillDTO;
import fr.phoenyx.arena.services.skill.PassiveSkillService;

@RestController
public class PassiveSkillController {

    @Autowired
    private PassiveSkillService passiveSkillService;

    @GetMapping("/passive-skills")
    public List<PassiveSkillDTO> findAll() {
        return passiveSkillService.findAll();
    }

    @GetMapping("/passive-skills/{id}")
    public PassiveSkillDTO findById(@PathVariable Long id) {
        return passiveSkillService.findById(id);
    }
}
