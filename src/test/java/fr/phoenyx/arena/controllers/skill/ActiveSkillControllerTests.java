package fr.phoenyx.arena.controllers.skill;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import fr.phoenyx.arena.advices.BadRequestAdvice;
import fr.phoenyx.arena.advices.EntityNotFoundAdvice;
import fr.phoenyx.arena.advices.GenericAdvice;
import fr.phoenyx.arena.builders.skill.ActiveSkillBuilder;
import fr.phoenyx.arena.controllers.CrudControllerTests;
import fr.phoenyx.arena.dtos.skill.ActiveSkillDTO;
import fr.phoenyx.arena.enums.skill.ActiveSkillEnum;
import fr.phoenyx.arena.models.skill.ActiveSkill;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.skill.ActiveSkillService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ActiveSkillControllerTests extends CrudControllerTests<ActiveSkill, Long, ActiveSkillDTO> {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ActiveSkillService activeSkillService;

    @InjectMocks
    private ActiveSkillController activeSkillController;

    @Override
    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    protected CrudService<ActiveSkill, Long, ActiveSkillDTO> getService() {
        return activeSkillService;
    }

    @Override
    protected String getEndpointRoot() {
        return "/active-skills";
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
    protected ActiveSkillDTO buildDTO() {
        ActiveSkill activeSkill = new ActiveSkillBuilder()
                .activeSkillEnum(ActiveSkillEnum.values()[0])
                .id(GENERIC_ID).build();
        return new ActiveSkillDTO(activeSkill);
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(activeSkillController)
                .setControllerAdvice(new GenericAdvice(), new EntityNotFoundAdvice(), new BadRequestAdvice())
                .build();
    }
}
