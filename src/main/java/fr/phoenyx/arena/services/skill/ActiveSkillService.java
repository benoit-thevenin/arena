package fr.phoenyx.arena.services.skill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.models.skill.ActiveSkill;
import fr.phoenyx.arena.repositories.skill.ActiveSkillRepository;

@Service
public class ActiveSkillService {

    @Autowired
    private ActiveSkillRepository activeSkillRepository;

    public List<ActiveSkill> gettAllActiveSkills() {
        return activeSkillRepository.findAll();
    }
}
