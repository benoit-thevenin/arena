package fr.phoenyx.arena.controllers.battle;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static fr.phoenyx.arena.constants.RestConstants.ROOT_HERO_BUILDS;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
import fr.phoenyx.arena.builders.battle.HeroBuildBuilder;
import fr.phoenyx.arena.controllers.CrudControllerTests;
import fr.phoenyx.arena.dtos.battle.HeroBuildDTO;
import fr.phoenyx.arena.enums.skill.ActiveSkillEnum;
import fr.phoenyx.arena.enums.skill.PassiveSkillEnum;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.models.battle.Hero;
import fr.phoenyx.arena.models.battle.HeroBuild;
import fr.phoenyx.arena.models.item.Item;
import fr.phoenyx.arena.models.skill.ActiveSkill;
import fr.phoenyx.arena.models.skill.PassiveSkill;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.battle.HeroBuildService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HeroBuildControllerTests extends CrudControllerTests<HeroBuild, Long, HeroBuildDTO> {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private HeroBuildService heroBuildService;

    @InjectMocks
    private HeroBuildController heroBuildController;

    @Override
    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    protected CrudService<HeroBuild, Long, HeroBuildDTO> getService() {
        return heroBuildService;
    }

    @Override
    protected String getEndpointRoot() {
        return ROOT_HERO_BUILDS;
    }

    @Override
    protected Class<HeroBuild> getConcernedClass() {
        return HeroBuild.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected HeroBuildDTO buildDTO() {
        ActiveSkill activeSkill = mock(ActiveSkill.class);
        PassiveSkill passiveSkill = mock(PassiveSkill.class);
        when(activeSkill.getActiveSkillEnum()).thenReturn(ActiveSkillEnum.values()[0]);
        when(passiveSkill.getPassiveSkillEnum()).thenReturn(PassiveSkillEnum.values()[0]);
        HeroBuild heroBuild = new HeroBuildBuilder()
                .heroes(Arrays.asList(mock(Hero.class)))
                .vitality(0)
                .strength(0)
                .intelligence(0)
                .agility(0)
                .activeSkills(Arrays.asList(activeSkill))
                .passiveSkills(Arrays.asList(passiveSkill))
                .stuff(Arrays.asList(mock(Item.class)))
                .id(GENERIC_ID)
                .dateCreation(LocalDateTime.now())
                .dateModification(LocalDateTime.now())
                .modifier(mock(Player.class)).build();
        return new HeroBuildDTO(heroBuild);
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(heroBuildController)
                .setControllerAdvice(new GenericAdvice(), new EntityNotFoundAdvice(), new BadRequestAdvice())
                .build();
    }
}
