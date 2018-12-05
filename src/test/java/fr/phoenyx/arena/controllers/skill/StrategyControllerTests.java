package fr.phoenyx.arena.controllers.skill;

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
import fr.phoenyx.arena.advices.skill.StrategyAdvice;
import fr.phoenyx.arena.dtos.skill.StrategyDTO;
import fr.phoenyx.arena.exceptions.skill.StrategyException;
import fr.phoenyx.arena.models.skill.Strategy;
import fr.phoenyx.arena.services.skill.StrategyService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StrategyControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private StrategyService strategyService;

    @InjectMocks
    private StrategyController strategyController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(strategyController)
                .setControllerAdvice(new GenericAdvice(), new GenericEntityAdvice(), new StrategyAdvice())
                .build();
    }

    @Test
    public void findAll_shouldReturnOK() throws Exception {
        mockMvc.perform(get("/strategies"))
                .andExpect(status().isOk());
    }

    @Test
    public void findById_shouldReturnOK_whenExists() throws Exception {
        //Given
        StrategyDTO strategy = new StrategyDTO();
        strategy.setId(GENERIC_ID);
        when(strategyService.findById(GENERIC_ID)).thenReturn(strategy);

        //When Then
        mockMvc.perform(get("/strategies/" + GENERIC_ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(Long.toString(GENERIC_ID))));
    }

    @Test
    public void findById_shouldReturnNotFound_whenNotExists() throws Exception {
        //Given
        when(strategyService.findById(GENERIC_ID)).thenThrow(StrategyException.entityNotFound(GENERIC_ID));

        //When Then
        mockMvc.perform(get("/strategies/" + GENERIC_ID))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString(Strategy.class.getSimpleName() + " not found : " + GENERIC_ID)));
    }
}
