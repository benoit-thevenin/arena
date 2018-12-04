package fr.phoenyx.arena.controllers.skill;

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
import fr.phoenyx.arena.advices.skill.ActiveSkillAdvice;
import fr.phoenyx.arena.dtos.skill.ActiveSkillDTO;
import fr.phoenyx.arena.exceptions.skill.ActiveSkillException;
import fr.phoenyx.arena.models.skill.ActiveSkill;
import fr.phoenyx.arena.services.skill.ActiveSkillService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ActiveSkillControllerTests {

    private static final long ID = 0L;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ActiveSkillService activeSkillService;

    @InjectMocks
    private ActiveSkillController activeSkillController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(activeSkillController)
                .setControllerAdvice(new GenericAdvice(), new GenericEntityAdvice(), new ActiveSkillAdvice())
                .build();
    }

    @Test
    public void findAll_shouldReturnOK() throws Exception {
        mockMvc.perform(get("/active-skills"))
                .andExpect(status().isOk());
    }

    @Test
    public void findById_shouldReturnOK_whenExists() throws Exception {
        //Given
        ActiveSkillDTO activeSkill = new ActiveSkillDTO();
        activeSkill.setId(ID);
        when(activeSkillService.findById(ID)).thenReturn(activeSkill);

        //When Then
        mockMvc.perform(get("/active-skills/" + ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(Long.toString(ID))));
    }

    @Test
    public void findById_shouldReturnNotFound_whenNotExists() throws Exception {
        //Given
        when(activeSkillService.findById(ID)).thenThrow(ActiveSkillException.entityNotFound(ID));

        //When Then
        mockMvc.perform(get("/active-skills/" + ID))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString(ActiveSkill.class.getSimpleName() + " not found : " + ID)));
    }
}
