package fr.phoenyx.arena.services.skill;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.skill.ActiveSkillDTO;
import fr.phoenyx.arena.repositories.skill.ActiveSkillRepository;

@Service
public class ActiveSkillService {

    @Autowired
    private ActiveSkillRepository activeSkillRepository;

    public List<ActiveSkillDTO> gettAllActiveSkills() {
        return activeSkillRepository.findAll().stream()
                .map(activeSkill -> new ActiveSkillDTO(activeSkill))
                .collect(Collectors.toList());
    }
}
