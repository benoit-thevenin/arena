package fr.phoenyx.arena.controllers.battle;

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
import fr.phoenyx.arena.advices.battle.BattleAdvice;
import fr.phoenyx.arena.dtos.battle.BattleDTO;
import fr.phoenyx.arena.exceptions.battle.BattleException;
import fr.phoenyx.arena.models.battle.Battle;
import fr.phoenyx.arena.services.battle.BattleService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BattleControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BattleService battleService;

    @InjectMocks
    private BattleController battleController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(battleController)
                .setControllerAdvice(new GenericAdvice(), new GenericEntityAdvice(), new BattleAdvice())
                .build();
    }

    @Test
    public void findAll_shouldReturnOK() throws Exception {
        mockMvc.perform(get("/battles"))
                .andExpect(status().isOk());
    }

    @Test
    public void findById_shouldReturnOK_whenExists() throws Exception {
        //Given
        BattleDTO battle = new BattleDTO();
        battle.setId(GENERIC_ID);
        when(battleService.findById(GENERIC_ID)).thenReturn(battle);

        //When Then
        mockMvc.perform(get("/battles/" + GENERIC_ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(Long.toString(GENERIC_ID))));
    }

    @Test
    public void findById_shouldReturnNotFound_whenNotExists() throws Exception {
        //Given
        when(battleService.findById(GENERIC_ID)).thenThrow(BattleException.entityNotFound(GENERIC_ID));

        //When Then
        mockMvc.perform(get("/battles/" + GENERIC_ID))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString(Battle.class.getSimpleName() + " not found : " + GENERIC_ID)));
    }
}
