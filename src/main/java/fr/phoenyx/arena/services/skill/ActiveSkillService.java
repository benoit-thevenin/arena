package fr.phoenyx.arena.services.skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.skill.ActiveSkillDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.skill.ActiveSkillMapper;
import fr.phoenyx.arena.models.skill.ActiveSkill;
import fr.phoenyx.arena.repositories.skill.ActiveSkillRepository;
import fr.phoenyx.arena.services.CrudService;

@Service
public class ActiveSkillService extends CrudService<ActiveSkill, Long, ActiveSkillDTO> {

    @Autowired
    private ActiveSkillRepository activeSkillRepository;

    @Override
    protected JpaRepository<ActiveSkill, Long> getRepository() {
        return activeSkillRepository;
    }

    @Override
    protected Mapper<ActiveSkill, ActiveSkillDTO> getMapper() {
        return new ActiveSkillMapper();
    }

    @Override
    protected Class<ActiveSkill> getConcernedClass() {
        return ActiveSkill.class;
    }
}
