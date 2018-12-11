package fr.phoenyx.arena.controllers.skill;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static fr.phoenyx.arena.constants.RestConstants.ROOT_STRATEGIES;

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
import fr.phoenyx.arena.builders.skill.StrategyBuilder;
import fr.phoenyx.arena.controllers.CrudControllerTests;
import fr.phoenyx.arena.dtos.skill.StrategyDTO;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.models.skill.Strategy;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.skill.StrategyService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StrategyControllerTests extends CrudControllerTests<Strategy, Long, StrategyDTO> {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private StrategyService strategyService;

    @InjectMocks
    private StrategyController strategyController;

    @Override
    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    protected CrudService<Strategy, Long, StrategyDTO> getService() {
        return strategyService;
    }

    @Override
    protected String getEndpointRoot() {
        return ROOT_STRATEGIES;
    }

    @Override
    protected Class<Strategy> getConcernedClass() {
        return Strategy.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected StrategyDTO buildDTO() {
        Strategy strategy = new StrategyBuilder()
                .targetPredicate("targetPredicate")
                .priority(0)
                .buff(false)
                .id(GENERIC_ID)
                .dateCreation(LocalDateTime.now())
                .dateModification(LocalDateTime.now())
                .modifier(mock(Player.class)).build();
        return new StrategyDTO(strategy);
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(strategyController)
                .setControllerAdvice(new GenericAdvice(), new EntityNotFoundAdvice(), new BadRequestAdvice())
                .build();
    }
}
