package fr.phoenyx.arena.controllers.item;

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
import fr.phoenyx.arena.advices.item.BonusAdvice;
import fr.phoenyx.arena.dtos.item.BonusDTO;
import fr.phoenyx.arena.exceptions.item.BonusException;
import fr.phoenyx.arena.models.item.Bonus;
import fr.phoenyx.arena.services.item.BonusService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BonusControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BonusService bonusService;

    @InjectMocks
    private BonusController bonusController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(bonusController)
                .setControllerAdvice(new GenericAdvice(), new GenericEntityAdvice(), new BonusAdvice())
                .build();
    }

    @Test
    public void findAll_shouldReturnOK() throws Exception {
        mockMvc.perform(get("/bonuses"))
                .andExpect(status().isOk());
    }

    @Test
    public void findById_shouldReturnOK_whenExists() throws Exception {
        //Given
        BonusDTO bonus = new BonusDTO();
        bonus.setId(GENERIC_ID);
        when(bonusService.findById(GENERIC_ID)).thenReturn(bonus);

        //When Then
        mockMvc.perform(get("/bonuses/" + GENERIC_ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(Long.toString(GENERIC_ID))));
    }

    @Test
    public void findById_shouldReturnNotFound_whenNotExists() throws Exception {
        //Given
        when(bonusService.findById(GENERIC_ID)).thenThrow(BonusException.entityNotFound(GENERIC_ID));

        //When Then
        mockMvc.perform(get("/bonuses/" + GENERIC_ID))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString(Bonus.class.getSimpleName() + " not found : " + GENERIC_ID)));
    }
}
