package fr.phoenyx.arena.services.skill;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.skill.PassiveSkillDTO;
import fr.phoenyx.arena.exceptions.BadRequestException;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.skill.PassiveSkillMapper;
import fr.phoenyx.arena.models.skill.PassiveSkill;
import fr.phoenyx.arena.repositories.skill.PassiveSkillRepository;
import fr.phoenyx.arena.services.CrudService;

@Service
public class PassiveSkillService extends CrudService<PassiveSkill, PassiveSkillDTO> {

    @Autowired
    private PassiveSkillRepository passiveSkillRepository;

    @Override
    protected JpaRepository<PassiveSkill, Long> getRepository() {
        return passiveSkillRepository;
    }

    @Override
    protected Mapper<PassiveSkill, PassiveSkillDTO> getMapper() {
        return new PassiveSkillMapper();
    }

    @Override
    protected Class<PassiveSkill> getConcernedClass() {
        return PassiveSkill.class;
    }

    @Override
    public PassiveSkillDTO create(PassiveSkillDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    public PassiveSkillDTO update(PassiveSkillDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }
}
