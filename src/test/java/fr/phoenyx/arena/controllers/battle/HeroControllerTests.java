package fr.phoenyx.arena.controllers.battle;

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
import fr.phoenyx.arena.advices.battle.HeroAdvice;
import fr.phoenyx.arena.dtos.battle.HeroDTO;
import fr.phoenyx.arena.exceptions.battle.HeroException;
import fr.phoenyx.arena.models.battle.Hero;
import fr.phoenyx.arena.services.battle.HeroService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HeroControllerTests {

    private static final long ID = 0L;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private HeroService heroService;

    @InjectMocks
    private HeroController heroController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(heroController)
                .setControllerAdvice(new GenericAdvice(), new GenericEntityAdvice(), new HeroAdvice())
                .build();
    }

    @Test
    public void findAll_shouldReturnOK() throws Exception {
        mockMvc.perform(get("/heroes"))
                .andExpect(status().isOk());
    }

    @Test
    public void findById_shouldReturnOK_whenExists() throws Exception {
        //Given
        HeroDTO heroes = new HeroDTO();
        heroes.setId(ID);
        when(heroService.findById(ID)).thenReturn(heroes);

        //When Then
        mockMvc.perform(get("/heroes/" + ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(Long.toString(ID))));
    }

    @Test
    public void findById_shouldReturnNotFound_whenNotExists() throws Exception {
        //Given
        when(heroService.findById(ID)).thenThrow(HeroException.entityNotFound(ID));

        //When Then
        mockMvc.perform(get("/heroes/" + ID))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString(Hero.class.getSimpleName() + " not found : " + ID)));
    }
}
