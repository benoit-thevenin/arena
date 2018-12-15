package fr.phoenyx.arena.mappers.skill;

import fr.phoenyx.arena.dtos.skill.ActiveSkillDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.skill.ActiveSkill;

public class ActiveSkillMapper implements Mapper<ActiveSkill, ActiveSkillDTO> {

    @Override
    public ActiveSkillDTO entityToDto(ActiveSkill entity) {
        return new ActiveSkillDTO(entity);
    }
}
