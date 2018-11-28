package fr.phoenyx.arena.controller.skill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ActiveSkillDTO> findAll() {
        return activeSkillService.findAll();
    }

    @GetMapping("/active-skills/{id}")
    public ActiveSkillDTO findById(@PathVariable Long id) {
        return activeSkillService.findById(id);
    }
}
