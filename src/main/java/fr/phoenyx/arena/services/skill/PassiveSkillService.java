package fr.phoenyx.arena.services.skill;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.skill.PassiveSkillDTO;
import fr.phoenyx.arena.exceptions.skill.PassiveSkillException;
import fr.phoenyx.arena.models.skill.PassiveSkill;
import fr.phoenyx.arena.repositories.skill.PassiveSkillRepository;

@Service
public class PassiveSkillService {

    @Autowired
    private PassiveSkillRepository passiveSkillRepository;

    public List<PassiveSkillDTO> findAll() {
        return passiveSkillRepository.findAll().stream()
                .map(PassiveSkillDTO::new)
                .collect(Collectors.toList());
    }

    public PassiveSkillDTO findById(Long id) {
        PassiveSkill passiveSkill = passiveSkillRepository.findById(id)
                .orElseThrow(() -> PassiveSkillException.entityNotFound(id));
        return new PassiveSkillDTO(passiveSkill);
    }
}
