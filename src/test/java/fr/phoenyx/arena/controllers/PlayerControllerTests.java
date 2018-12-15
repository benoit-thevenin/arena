package fr.phoenyx.arena.controllers;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static fr.phoenyx.arena.constants.RestConstants.ROOT_PLAYERS;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

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
import fr.phoenyx.arena.builders.PlayerBuilder;
import fr.phoenyx.arena.dtos.PlayerDTO;
import fr.phoenyx.arena.enums.GuildRole;
import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.models.guild.Guild;
import fr.phoenyx.arena.models.item.Item;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.PlayerService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerTests extends CrudControllerTests<Player, PlayerDTO> {

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
    protected CrudService<Player, PlayerDTO> getService() {
        return playerService;
    }

    @Override
    protected String getEndpointRoot() {
        return ROOT_PLAYERS;
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
                .username("username")
                .email("email")
                .lastConnection(LocalDateTime.now())
                .gold(0)
                .level(0)
                .experience(0)
                .inventory(Arrays.asList(mock(Item.class)))
                .builds(new HashSet<>(Arrays.asList(mock(Build.class))))
                .guild(mock(Guild.class))
                .guildRole(GuildRole.values()[0])
                .friends(new HashSet<>(Arrays.asList(mock(Player.class))))
                .id(GENERIC_ID)
                .dateCreation(LocalDateTime.now())
                .dateModification(LocalDateTime.now())
                .modifier(mock(Player.class)).build();
        return new PlayerDTO(player);
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(playerController)
                .setControllerAdvice(new GenericAdvice(), new EntityNotFoundAdvice(), new BadRequestAdvice())
                .build();
    }
}
