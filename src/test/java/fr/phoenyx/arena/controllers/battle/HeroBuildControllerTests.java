package fr.phoenyx.arena.controllers.battle;

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
import fr.phoenyx.arena.builders.battle.HeroBuildBuilder;
import fr.phoenyx.arena.controllers.CrudControllerTests;
import fr.phoenyx.arena.dtos.battle.HeroBuildDTO;
import fr.phoenyx.arena.models.battle.HeroBuild;
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
        return "/hero-builds";
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
        HeroBuild heroBuild = new HeroBuildBuilder()
                .id(GENERIC_ID).build();
        return new HeroBuildDTO(heroBuild);
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(heroBuildController)
                .setControllerAdvice(new GenericAdvice(), new EntityNotFoundAdvice(), new BadRequestAdvice())
                .build();
    }
}
