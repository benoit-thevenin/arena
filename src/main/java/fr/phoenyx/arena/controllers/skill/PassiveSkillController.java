package fr.phoenyx.arena.controllers.skill;

import static fr.phoenyx.arena.constants.RestConstants.ROOT_PASSIVE_SKILLS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.controllers.CrudController;
import fr.phoenyx.arena.dtos.skill.PassiveSkillDTO;
import fr.phoenyx.arena.models.skill.PassiveSkill;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.skill.PassiveSkillService;

@RestController
@RequestMapping(ROOT_PASSIVE_SKILLS)
public class PassiveSkillController extends CrudController<PassiveSkill, PassiveSkillDTO> {

    @Autowired
    private PassiveSkillService passiveSkillService;

    @Override
    protected CrudService<PassiveSkill, PassiveSkillDTO> getService() {
        return passiveSkillService;
    }
}
