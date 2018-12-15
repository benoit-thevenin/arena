package fr.phoenyx.arena.controllers.guild;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static fr.phoenyx.arena.constants.RestConstants.ROOT_GUILDS;

import java.time.LocalDateTime;
import java.util.Arrays;

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
import fr.phoenyx.arena.builders.guild.GuildBuilder;
import fr.phoenyx.arena.controllers.CrudControllerTests;
import fr.phoenyx.arena.dtos.guild.GuildDTO;
import fr.phoenyx.arena.models.Applicant;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.models.guild.Guild;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.guild.GuildService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GuildControllerTests extends CrudControllerTests<Guild, GuildDTO> {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private GuildService guildService;

    @InjectMocks
    private GuildController guildController;

    @Override
    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    protected CrudService<Guild, GuildDTO> getService() {
        return guildService;
    }

    @Override
    protected String getEndpointRoot() {
        return ROOT_GUILDS;
    }

    @Override
    protected Class<Guild> getConcernedClass() {
        return Guild.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected GuildDTO buildDTO() {
        Guild guild = new GuildBuilder()
                .name("name")
                .description("description")
                .members(Arrays.asList(mock(Player.class)))
                .applicants(Arrays.asList(mock(Applicant.class)))
                .id(GENERIC_ID)
                .dateCreation(LocalDateTime.now())
                .dateModification(LocalDateTime.now())
                .modifier(mock(Player.class)).build();
        return new GuildDTO(guild);
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(guildController)
                .setControllerAdvice(new GenericAdvice(), new EntityNotFoundAdvice(), new BadRequestAdvice())
                .build();
    }
}
