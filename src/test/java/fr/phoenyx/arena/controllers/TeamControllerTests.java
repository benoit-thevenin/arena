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
import fr.phoenyx.arena.builders.TeamBuilder;
import fr.phoenyx.arena.dtos.TeamDTO;
import fr.phoenyx.arena.models.Team;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.TeamService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TeamControllerTests extends CrudControllerTests<Team, Long, TeamDTO> {

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
    protected CrudService<Team, Long, TeamDTO> getService() {
        return teamService;
    }

    @Override
    protected String getEndpointRoot() {
        return "/teams";
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
                .id(GENERIC_ID).build();
        return new TeamDTO(team);
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(teamController)
                .setControllerAdvice(new GenericAdvice(), new EntityNotFoundAdvice(), new BadRequestAdvice())
                .build();
    }
}
