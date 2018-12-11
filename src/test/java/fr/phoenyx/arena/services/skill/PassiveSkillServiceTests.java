package fr.phoenyx.arena.services.skill;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import fr.phoenyx.arena.builders.skill.PassiveSkillBuilder;
import fr.phoenyx.arena.dtos.skill.PassiveSkillDTO;
import fr.phoenyx.arena.enums.skill.PassiveSkillEnum;
import fr.phoenyx.arena.models.skill.PassiveSkill;
import fr.phoenyx.arena.repositories.skill.PassiveSkillRepository;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.CrudServiceTests;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PassiveSkillServiceTests extends CrudServiceTests<PassiveSkill, Long, PassiveSkillDTO> {

    @Mock
    private PassiveSkillRepository passiveSkillRepository;

    @InjectMocks
    private PassiveSkillService passiveSkillService;

    @Override
    protected JpaRepository<PassiveSkill, Long> getRepository() {
        return passiveSkillRepository;
    }

    @Override
    protected CrudService<PassiveSkill, Long, PassiveSkillDTO> getService() {
        return passiveSkillService;
    }

    @Override
    protected Class<PassiveSkill> getConcernedClass() {
        return PassiveSkill.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected PassiveSkill buildEntity() {
        return new PassiveSkillBuilder()
                .passiveSkillEnum(PassiveSkillEnum.values()[0])
                .id(GENERIC_ID).build();
    }

    @Override
    protected List<PassiveSkill> buildEntities() {
        return Arrays.asList(buildEntity());
    }
}
