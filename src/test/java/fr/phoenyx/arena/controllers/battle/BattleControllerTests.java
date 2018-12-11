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
import fr.phoenyx.arena.builders.battle.BattleBuilder;
import fr.phoenyx.arena.controllers.CrudControllerTests;
import fr.phoenyx.arena.dtos.battle.BattleDTO;
import fr.phoenyx.arena.models.battle.Battle;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.battle.BattleService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BattleControllerTests extends CrudControllerTests<Battle, Long, BattleDTO> {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BattleService battleService;

    @InjectMocks
    private BattleController battleController;

    @Override
    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    protected CrudService<Battle, Long, BattleDTO> getService() {
        return battleService;
    }

    @Override
    protected String getEndpointRoot() {
        return "/battles";
    }

    @Override
    protected Class<Battle> getConcernedClass() {
        return Battle.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected BattleDTO buildDTO() {
        Battle battle = new BattleBuilder()
                .id(GENERIC_ID).build();
        return new BattleDTO(battle);
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(battleController)
                .setControllerAdvice(new GenericAdvice(), new EntityNotFoundAdvice(), new BadRequestAdvice())
                .build();
    }
}
