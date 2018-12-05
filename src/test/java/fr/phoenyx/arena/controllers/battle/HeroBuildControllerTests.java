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
import fr.phoenyx.arena.advices.battle.HeroBuildAdvice;
import fr.phoenyx.arena.dtos.battle.HeroBuildDTO;
import fr.phoenyx.arena.exceptions.battle.HeroBuildException;
import fr.phoenyx.arena.models.battle.HeroBuild;
import fr.phoenyx.arena.services.battle.HeroBuildService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HeroBuildControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private HeroBuildService heroBuildService;

    @InjectMocks
    private HeroBuildController heroBuildController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(heroBuildController)
                .setControllerAdvice(new GenericAdvice(), new GenericEntityAdvice(), new HeroBuildAdvice())
                .build();
    }

    @Test
    public void findAll_shouldReturnOK() throws Exception {
        mockMvc.perform(get("/hero-builds"))
                .andExpect(status().isOk());
    }

    @Test
    public void findById_shouldReturnOK_whenExists() throws Exception {
        //Given
        HeroBuildDTO heroBuild = new HeroBuildDTO();
        heroBuild.setId(GENERIC_ID);
        when(heroBuildService.findById(GENERIC_ID)).thenReturn(heroBuild);

        //When Then
        mockMvc.perform(get("/hero-builds/" + GENERIC_ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(Long.toString(GENERIC_ID))));
    }

    @Test
    public void findById_shouldReturnNotFound_whenNotExists() throws Exception {
        //Given
        when(heroBuildService.findById(GENERIC_ID)).thenThrow(HeroBuildException.entityNotFound(GENERIC_ID));

        //When Then
        mockMvc.perform(get("/hero-builds/" + GENERIC_ID))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString(HeroBuild.class.getSimpleName() + " not found : " + GENERIC_ID)));
    }
}
