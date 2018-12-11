package fr.phoenyx.arena.mappers.skill;

import fr.phoenyx.arena.dtos.skill.PassiveSkillDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.skill.PassiveSkill;

public class PassiveSkillMapper implements Mapper<PassiveSkill, PassiveSkillDTO> {

    @Override
    public PassiveSkillDTO entityToDto(PassiveSkill entity) {
        return new PassiveSkillDTO(entity);
    }

    @Override
    public PassiveSkill dtoToEntity(PassiveSkillDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }
}
