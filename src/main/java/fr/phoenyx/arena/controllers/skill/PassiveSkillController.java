package fr.phoenyx.arena.controllers.skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.controllers.CrudController;
import fr.phoenyx.arena.dtos.skill.PassiveSkillDTO;
import fr.phoenyx.arena.models.skill.PassiveSkill;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.skill.PassiveSkillService;

@RestController
@RequestMapping("/passive-skills")
public class PassiveSkillController extends CrudController<PassiveSkill, Long, PassiveSkillDTO> {

    @Autowired
    private PassiveSkillService passiveSkillService;

    @Override
    protected CrudService<PassiveSkill, Long, PassiveSkillDTO> getService() {
        return passiveSkillService;
    }
}
