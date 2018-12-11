package fr.phoenyx.arena.controllers.skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.controllers.CrudController;
import fr.phoenyx.arena.dtos.skill.ActiveSkillDTO;
import fr.phoenyx.arena.models.skill.ActiveSkill;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.skill.ActiveSkillService;

@RestController
@RequestMapping("/active-skills")
public class ActiveSkillController extends CrudController<ActiveSkill, Long, ActiveSkillDTO> {

    @Autowired
    private ActiveSkillService activeSkillService;

    @Override
    protected CrudService<ActiveSkill, Long, ActiveSkillDTO> getService() {
        return activeSkillService;
    }
}
