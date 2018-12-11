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
import fr.phoenyx.arena.builders.battle.ActionBuilder;
import fr.phoenyx.arena.controllers.CrudControllerTests;
import fr.phoenyx.arena.dtos.battle.ActionDTO;
import fr.phoenyx.arena.models.battle.Action;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.battle.ActionService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ActionControllerTests extends CrudControllerTests<Action, Long, ActionDTO> {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ActionService actionService;

    @InjectMocks
    private ActionController actionController;

    @Override
    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    protected CrudService<Action, Long, ActionDTO> getService() {
        return actionService;
    }

    @Override
    protected String getEndpointRoot() {
        return "/actions";
    }

    @Override
    protected Class<Action> getConcernedClass() {
        return Action.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected ActionDTO buildDTO() {
        Action action = new ActionBuilder()
                .id(GENERIC_ID).build();
        return new ActionDTO(action);
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(actionController)
                .setControllerAdvice(new GenericAdvice(), new EntityNotFoundAdvice(), new BadRequestAdvice())
                .build();
    }
}
