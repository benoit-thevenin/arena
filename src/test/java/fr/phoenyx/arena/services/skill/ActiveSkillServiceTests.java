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

import fr.phoenyx.arena.builders.skill.ActiveSkillBuilder;
import fr.phoenyx.arena.dtos.skill.ActiveSkillDTO;
import fr.phoenyx.arena.enums.skill.ActiveSkillEnum;
import fr.phoenyx.arena.models.skill.ActiveSkill;
import fr.phoenyx.arena.repositories.skill.ActiveSkillRepository;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.CrudServiceTests;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveSkillServiceTests extends CrudServiceTests<ActiveSkill, Long, ActiveSkillDTO> {

    @Mock
    private ActiveSkillRepository activeSkillRepository;

    @InjectMocks
    private ActiveSkillService activeSkillService;

    @Override
    protected JpaRepository<ActiveSkill, Long> getRepository() {
        return activeSkillRepository;
    }

    @Override
    protected CrudService<ActiveSkill, Long, ActiveSkillDTO> getService() {
        return activeSkillService;
    }

    @Override
    protected Class<ActiveSkill> getConcernedClass() {
        return ActiveSkill.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected ActiveSkill buildEntity() {
        return new ActiveSkillBuilder()
                .activeSkillEnum(ActiveSkillEnum.values()[0])
                .id(GENERIC_ID).build();
    }

    @Override
    protected List<ActiveSkill> buildEntities() {
        return Arrays.asList(buildEntity());
    }
}
