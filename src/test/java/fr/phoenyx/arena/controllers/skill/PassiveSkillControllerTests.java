package fr.phoenyx.arena.controllers.skill;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static fr.phoenyx.arena.constants.RestConstants.ROOT_PASSIVE_SKILLS;

import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;

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
import fr.phoenyx.arena.builders.skill.PassiveSkillBuilder;
import fr.phoenyx.arena.controllers.CrudControllerTests;
import fr.phoenyx.arena.dtos.skill.PassiveSkillDTO;
import fr.phoenyx.arena.enums.skill.PassiveSkillEnum;
import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.models.skill.PassiveSkill;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.skill.PassiveSkillService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PassiveSkillControllerTests extends CrudControllerTests<PassiveSkill, PassiveSkillDTO> {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PassiveSkillService passiveSkillService;

    @InjectMocks
    private PassiveSkillController passiveSkillController;

    @Override
    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    protected CrudService<PassiveSkill, PassiveSkillDTO> getService() {
        return passiveSkillService;
    }

    @Override
    protected String getEndpointRoot() {
        return ROOT_PASSIVE_SKILLS;
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
    protected PassiveSkillDTO buildDTO() {
        PassiveSkill passiveSkill = new PassiveSkillBuilder()
                .build(mock(Build.class))
                .passiveSkillEnum(PassiveSkillEnum.values()[0])
                .id(GENERIC_ID)
                .dateCreation(LocalDateTime.now())
                .dateModification(LocalDateTime.now())
                .modifier(mock(Player.class)).build();
        return new PassiveSkillDTO(passiveSkill);
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(passiveSkillController)
                .setControllerAdvice(new GenericAdvice(), new EntityNotFoundAdvice(), new BadRequestAdvice())
                .build();
    }
}
