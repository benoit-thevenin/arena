package fr.phoenyx.arena.services.skill;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.skill.PassiveSkillDTO;
import fr.phoenyx.arena.repositories.skill.PassiveSkillRepository;

@Service
public class PassiveSkillService {

    @Autowired
    private PassiveSkillRepository passiveSkillRepository;

    public List<PassiveSkillDTO> getAllPassiveSkills() {
        return passiveSkillRepository.findAll().stream()
                .map(PassiveSkillDTO::new)
                .collect(Collectors.toList());
    }
}
