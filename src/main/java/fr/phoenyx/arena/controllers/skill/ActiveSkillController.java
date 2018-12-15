package fr.phoenyx.arena.controllers.skill;

import static fr.phoenyx.arena.constants.RestConstants.ROOT_ACTIVE_SKILLS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.controllers.CrudController;
import fr.phoenyx.arena.dtos.skill.ActiveSkillDTO;
import fr.phoenyx.arena.models.skill.ActiveSkill;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.skill.ActiveSkillService;

@RestController
@RequestMapping(ROOT_ACTIVE_SKILLS)
public class ActiveSkillController extends CrudController<ActiveSkill, ActiveSkillDTO> {

    @Autowired
    private ActiveSkillService activeSkillService;

    @Override
    protected CrudService<ActiveSkill, ActiveSkillDTO> getService() {
        return activeSkillService;
    }
}
