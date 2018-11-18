package fr.phoenyx.arena.services.skill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.models.skill.PassiveSkill;
import fr.phoenyx.arena.repositories.skill.PassiveSkillRepository;

@Service
public class PassiveSkillService {

    @Autowired
    private PassiveSkillRepository passiveSkillRepository;

    public List<PassiveSkill> getAllPassiveSkills() {
        return passiveSkillRepository.findAll();
    }
}
