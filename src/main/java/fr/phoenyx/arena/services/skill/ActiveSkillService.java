package fr.phoenyx.arena.services.skill;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.skill.ActiveSkillDTO;
import fr.phoenyx.arena.exceptions.skill.ActiveSkillException;
import fr.phoenyx.arena.models.skill.ActiveSkill;
import fr.phoenyx.arena.repositories.skill.ActiveSkillRepository;

@Service
public class ActiveSkillService {

    @Autowired
    private ActiveSkillRepository activeSkillRepository;

    public List<ActiveSkillDTO> findAll() {
        return activeSkillRepository.findAll().stream()
                .map(ActiveSkillDTO::new)
                .collect(Collectors.toList());
    }

    public ActiveSkillDTO findById(Long id) {
        ActiveSkill activeSkill = activeSkillRepository.findById(id)
                .orElseThrow(() -> ActiveSkillException.entityNotFound(id));
        return new ActiveSkillDTO(activeSkill);
    }
}
