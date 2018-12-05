package fr.phoenyx.arena.controllers.guild;

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
import fr.phoenyx.arena.advices.guild.GuildAdvice;
import fr.phoenyx.arena.dtos.guild.GuildDTO;
import fr.phoenyx.arena.exceptions.guild.GuildException;
import fr.phoenyx.arena.models.guild.Guild;
import fr.phoenyx.arena.services.guild.GuildService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GuildControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private GuildService guildService;

    @InjectMocks
    private GuildController guildController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(guildController)
                .setControllerAdvice(new GenericAdvice(), new GenericEntityAdvice(), new GuildAdvice())
                .build();
    }

    @Test
    public void findAll_shouldReturnOK() throws Exception {
        mockMvc.perform(get("/guilds"))
                .andExpect(status().isOk());
    }

    @Test
    public void findById_shouldReturnOK_whenExists() throws Exception {
        //Given
        GuildDTO guild = new GuildDTO();
        guild.setId(GENERIC_ID);
        when(guildService.findById(GENERIC_ID)).thenReturn(guild);

        //When Then
        mockMvc.perform(get("/guilds/" + GENERIC_ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(Long.toString(GENERIC_ID))));
    }

    @Test
    public void findById_shouldReturnNotFound_whenNotExists() throws Exception {
        //Given
        when(guildService.findById(GENERIC_ID)).thenThrow(GuildException.entityNotFound(GENERIC_ID));

        //When Then
        mockMvc.perform(get("/guilds/" + GENERIC_ID))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString(Guild.class.getSimpleName() + " not found : " + GENERIC_ID)));
    }
}
