package fr.phoenyx.arena.controllers.guild;

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
import fr.phoenyx.arena.advices.guild.GuildMemberAdvice;
import fr.phoenyx.arena.dtos.guild.GuildMemberDTO;
import fr.phoenyx.arena.exceptions.guild.GuildMemberException;
import fr.phoenyx.arena.models.guild.GuildMember;
import fr.phoenyx.arena.services.guild.GuildMemberService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GuildMemberControllerTests {

    private static final long ID = 0L;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private GuildMemberService guildMemberService;

    @InjectMocks
    private GuildMemberController guildMemberController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(guildMemberController)
                .setControllerAdvice(new GenericAdvice(), new GenericEntityAdvice(), new GuildMemberAdvice())
                .build();
    }

    @Test
    public void findAll_shouldReturnOK() throws Exception {
        mockMvc.perform(get("/guild-members"))
                .andExpect(status().isOk());
    }

    @Test
    public void findById_shouldReturnOK_whenExists() throws Exception {
        //Given
        GuildMemberDTO guildMember = new GuildMemberDTO();
        guildMember.setId(ID);
        when(guildMemberService.findById(ID)).thenReturn(guildMember);

        //When Then
        mockMvc.perform(get("/guild-members/" + ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(Long.toString(ID))));
    }

    @Test
    public void findById_shouldReturnNotFound_whenNotExists() throws Exception {
        //Given
        when(guildMemberService.findById(ID)).thenThrow(GuildMemberException.entityNotFound(ID));

        //When Then
        mockMvc.perform(get("/guild-members/" + ID))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString(GuildMember.class.getSimpleName() + " not found : " + ID)));
    }
}
