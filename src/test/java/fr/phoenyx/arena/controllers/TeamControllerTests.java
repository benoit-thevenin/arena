package fr.phoenyx.arena.controllers;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import fr.phoenyx.arena.advices.GenericAdvice;
import fr.phoenyx.arena.advices.GenericEntityAdvice;
import fr.phoenyx.arena.advices.TeamAdvice;
import fr.phoenyx.arena.dtos.TeamDTO;
import fr.phoenyx.arena.exceptions.TeamException;
import fr.phoenyx.arena.models.Team;
import fr.phoenyx.arena.services.TeamService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TeamControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TeamService teamService;

    @InjectMocks
    private TeamController teamController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(teamController)
                .setControllerAdvice(new GenericAdvice(), new GenericEntityAdvice(), new TeamAdvice())
                .build();
    }

    @Test
    public void findAll_shouldReturnOK() throws Exception {
        mockMvc.perform(get("/teams"))
                .andExpect(status().isOk());
    }

    @Test
    public void findById_shouldReturnOK_whenExists() throws Exception {
        //Given
        TeamDTO team = new TeamDTO();
        team.setId(GENERIC_ID);
        when(teamService.findById(GENERIC_ID)).thenReturn(team);

        //When Then
        mockMvc.perform(get("/teams/" + GENERIC_ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(Long.toString(GENERIC_ID))));
    }

    @Test
    public void findById_shouldReturnNotFound_whenNotExists() throws Exception {
        //Given
        when(teamService.findById(GENERIC_ID)).thenThrow(TeamException.entityNotFound(GENERIC_ID));

        //When Then
        mockMvc.perform(get("/teams/" + GENERIC_ID))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString(Team.class.getSimpleName() + " not found : " + GENERIC_ID)));
    }
}
