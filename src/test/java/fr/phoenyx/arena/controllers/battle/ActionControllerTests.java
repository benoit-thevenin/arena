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
import fr.phoenyx.arena.advices.battle.ActionAdvice;
import fr.phoenyx.arena.dtos.battle.ActionDTO;
import fr.phoenyx.arena.exceptions.battle.ActionException;
import fr.phoenyx.arena.models.battle.Action;
import fr.phoenyx.arena.services.battle.ActionService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ActionControllerTests {

    private static final long ID = 0L;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ActionService actionService;

    @InjectMocks
    private ActionController actionController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(actionController)
                .setControllerAdvice(new GenericAdvice(), new GenericEntityAdvice(), new ActionAdvice())
                .build();
    }

    @Test
    public void findAll_shouldReturnOK() throws Exception {
        mockMvc.perform(get("/actions"))
                .andExpect(status().isOk());
    }

    @Test
    public void findById_shouldReturnOK_whenExists() throws Exception {
        //Given
        ActionDTO action = new ActionDTO();
        action.setId(ID);
        when(actionService.findById(ID)).thenReturn(action);

        //When Then
        mockMvc.perform(get("/actions/" + ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(Long.toString(ID))));
    }

    @Test
    public void findById_shouldReturnNotFound_whenNotExists() throws Exception {
        //Given
        when(actionService.findById(ID)).thenThrow(ActionException.entityNotFound(ID));

        //When Then
        mockMvc.perform(get("/actions/" + ID))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString(Action.class.getSimpleName() + " not found : " + ID)));
    }
}
