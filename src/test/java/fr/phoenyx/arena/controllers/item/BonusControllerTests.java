package fr.phoenyx.arena.controllers.item;

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

    private static final long ID = 0L;

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
        bonus.setId(ID);
        when(bonusService.findById(ID)).thenReturn(bonus);

        //When Then
        mockMvc.perform(get("/bonuses/" + ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(Long.toString(ID))));
    }

    @Test
    public void findById_shouldReturnNotFound_whenNotExists() throws Exception {
        //Given
        when(bonusService.findById(ID)).thenThrow(BonusException.entityNotFound(ID));

        //When Then
        mockMvc.perform(get("/bonuses/" + ID))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString(Bonus.class.getSimpleName() + " not found : " + ID)));
    }
}
