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
import fr.phoenyx.arena.advices.battle.SheetAdvice;
import fr.phoenyx.arena.dtos.battle.SheetDTO;
import fr.phoenyx.arena.exceptions.battle.SheetException;
import fr.phoenyx.arena.models.battle.Sheet;
import fr.phoenyx.arena.services.battle.SheetService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SheetControllerTests {

    private static final long ID = 0L;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private SheetService sheetService;

    @InjectMocks
    private SheetController sheetController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(sheetController)
                .setControllerAdvice(new GenericAdvice(), new GenericEntityAdvice(), new SheetAdvice())
                .build();
    }

    @Test
    public void findAll_shouldReturnOK() throws Exception {
        mockMvc.perform(get("/sheets"))
                .andExpect(status().isOk());
    }

    @Test
    public void findById_shouldReturnOK_whenExists() throws Exception {
        //Given
        SheetDTO sheet = new SheetDTO();
        sheet.setId(ID);
        when(sheetService.findById(ID)).thenReturn(sheet);

        //When Then
        mockMvc.perform(get("/sheets/" + ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(Long.toString(ID))));
    }

    @Test
    public void findById_shouldReturnNotFound_whenNotExists() throws Exception {
        //Given
        when(sheetService.findById(ID)).thenThrow(SheetException.entityNotFound(ID));

        //When Then
        mockMvc.perform(get("/sheets/" + ID))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString(Sheet.class.getSimpleName() + " not found : " + ID)));
    }
}
