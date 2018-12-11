package fr.phoenyx.arena.controllers;

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
import fr.phoenyx.arena.builders.PlayerBuilder;
import fr.phoenyx.arena.dtos.PlayerDTO;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.PlayerService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerTests extends CrudControllerTests<Player, Long, PlayerDTO> {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PlayerService playerService;

    @InjectMocks
    private PlayerController playerController;

    @Override
    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    protected CrudService<Player, Long, PlayerDTO> getService() {
        return playerService;
    }

    @Override
    protected String getEndpointRoot() {
        return "/players";
    }

    @Override
    protected Class<Player> getConcernedClass() {
        return Player.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected PlayerDTO buildDTO() {
        Player player = new PlayerBuilder()
                .id(GENERIC_ID).build();
        return new PlayerDTO(player);
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(playerController)
                .setControllerAdvice(new GenericAdvice(), new EntityNotFoundAdvice(), new BadRequestAdvice())
                .build();
    }
}
