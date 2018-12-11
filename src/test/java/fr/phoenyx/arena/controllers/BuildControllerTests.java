package fr.phoenyx.arena.controllers;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static fr.phoenyx.arena.constants.RestConstants.ROOT_BUILDS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

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
import fr.phoenyx.arena.builders.BuildBuilder;
import fr.phoenyx.arena.dtos.BuildDTO;
import fr.phoenyx.arena.enums.Specialization;
import fr.phoenyx.arena.enums.Type;
import fr.phoenyx.arena.enums.skill.ActiveSkillEnum;
import fr.phoenyx.arena.enums.skill.PassiveSkillEnum;
import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.models.item.Item;
import fr.phoenyx.arena.models.skill.ActiveSkill;
import fr.phoenyx.arena.models.skill.PassiveSkill;
import fr.phoenyx.arena.services.BuildService;
import fr.phoenyx.arena.services.CrudService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BuildControllerTests extends CrudControllerTests<Build, Long, BuildDTO> {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BuildService buildService;

    @InjectMocks
    private BuildController buildController;

    @Override
    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    protected CrudService<Build, Long, BuildDTO> getService() {
        return buildService;
    }

    @Override
    protected String getEndpointRoot() {
        return ROOT_BUILDS;
    }

    @Override
    protected Class<Build> getConcernedClass() {
        return Build.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected BuildDTO buildDTO() {
        ActiveSkill activeSkill = mock(ActiveSkill.class);
        PassiveSkill passiveSkill = mock(PassiveSkill.class);
        when(activeSkill.getActiveSkillEnum()).thenReturn(ActiveSkillEnum.values()[0]);
        when(passiveSkill.getPassiveSkillEnum()).thenReturn(PassiveSkillEnum.values()[0]);
        Build build = new BuildBuilder()
                .owner(mock(Player.class))
                .vitality(0)
                .strength(0)
                .intelligence(0)
                .agility(0)
                .activeSkills(Arrays.asList(activeSkill))
                .passiveSkills(Arrays.asList(passiveSkill))
                .stuff(Arrays.asList(mock(Item.class)))
                .specialization(Specialization.values()[0])
                .types(new HashSet<>(Arrays.asList(Type.values()[0])))
                .id(GENERIC_ID)
                .dateCreation(LocalDateTime.now())
                .dateModification(LocalDateTime.now())
                .modifier(mock(Player.class)).build();
        return new BuildDTO(build);
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(buildController)
                .setControllerAdvice(new GenericAdvice(), new EntityNotFoundAdvice(), new BadRequestAdvice())
                .build();
    }
}
