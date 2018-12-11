package fr.phoenyx.arena.services.skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.skill.PassiveSkillDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.skill.PassiveSkillMapper;
import fr.phoenyx.arena.models.skill.PassiveSkill;
import fr.phoenyx.arena.repositories.skill.PassiveSkillRepository;
import fr.phoenyx.arena.services.CrudService;

@Service
public class PassiveSkillService extends CrudService<PassiveSkill, Long, PassiveSkillDTO> {

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
}
