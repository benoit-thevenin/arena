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
import fr.phoenyx.arena.builders.battle.RoundBuilder;
import fr.phoenyx.arena.controllers.CrudControllerTests;
import fr.phoenyx.arena.dtos.battle.RoundDTO;
import fr.phoenyx.arena.models.battle.Round;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.battle.RoundService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RoundControllerTests extends CrudControllerTests<Round, Long, RoundDTO> {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private RoundService roundService;

    @InjectMocks
    private RoundController roundController;

    @Override
    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    protected CrudService<Round, Long, RoundDTO> getService() {
        return roundService;
    }

    @Override
    protected String getEndpointRoot() {
        return "/rounds";
    }

    @Override
    protected Class<Round> getConcernedClass() {
        return Round.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected RoundDTO buildDTO() {
        Round round = new RoundBuilder()
                .id(GENERIC_ID).build();
        return new RoundDTO(round);
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(roundController)
                .setControllerAdvice(new GenericAdvice(), new EntityNotFoundAdvice(), new BadRequestAdvice())
                .build();
    }
}
