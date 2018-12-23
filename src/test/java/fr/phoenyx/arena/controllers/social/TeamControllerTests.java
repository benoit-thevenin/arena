package fr.phoenyx.arena.controllers.social;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static fr.phoenyx.arena.constants.RestConstants.ROOT_TEAMS;

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
import fr.phoenyx.arena.builders.social.TeamBuilder;
import fr.phoenyx.arena.controllers.CrudControllerTests;
import fr.phoenyx.arena.controllers.social.TeamController;
import fr.phoenyx.arena.dtos.social.TeamDTO;
import fr.phoenyx.arena.models.social.Applicant;
import fr.phoenyx.arena.models.social.Player;
import fr.phoenyx.arena.models.social.Team;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.social.TeamService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TeamControllerTests extends CrudControllerTests<Team, TeamDTO> {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TeamService teamService;

    @InjectMocks
    private TeamController teamController;

    @Override
    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    protected CrudService<Team, TeamDTO> getService() {
        return teamService;
    }

    @Override
    protected String getEndpointRoot() {
        return ROOT_TEAMS;
    }

    @Override
    protected Class<Team> getConcernedClass() {
        return Team.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected TeamDTO buildDTO() {
        Team team = new TeamBuilder()
                .dimension(0)
                .leader(mock(Player.class))
                .members(new HashSet<>(Arrays.asList(mock(Applicant.class))))
                .applicants(new HashSet<>(Arrays.asList(mock(Applicant.class))))
                .id(GENERIC_ID)
                .dateCreation(LocalDateTime.now())
                .dateModification(LocalDateTime.now())
                .modifier(mock(Player.class)).build();
        return new TeamDTO(team);
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(teamController)
                .setControllerAdvice(new GenericAdvice(), new EntityNotFoundAdvice(), new BadRequestAdvice())
                .build();
    }
}
