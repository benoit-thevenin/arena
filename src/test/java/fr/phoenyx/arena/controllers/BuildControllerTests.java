package fr.phoenyx.arena.controllers;

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

import fr.phoenyx.arena.advices.BuildAdvice;
import fr.phoenyx.arena.advices.GenericAdvice;
import fr.phoenyx.arena.advices.GenericEntityAdvice;
import fr.phoenyx.arena.dtos.BuildDTO;
import fr.phoenyx.arena.exceptions.BuildException;
import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.services.BuildService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BuildControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BuildService buildService;

    @InjectMocks
    private BuildController buildController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(buildController)
                .setControllerAdvice(new GenericAdvice(), new GenericEntityAdvice(), new BuildAdvice())
                .build();
    }

    @Test
    public void findAll_shouldReturnOK() throws Exception {
        mockMvc.perform(get("/builds"))
                .andExpect(status().isOk());
    }

    @Test
    public void findById_shouldReturnOK_whenExists() throws Exception {
        //Given
        BuildDTO build = new BuildDTO();
        build.setId(GENERIC_ID);
        when(buildService.findById(GENERIC_ID)).thenReturn(build);

        //When Then
        mockMvc.perform(get("/builds/" + GENERIC_ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(Long.toString(GENERIC_ID))));
    }

    @Test
    public void findById_shouldReturnNotFound_whenNotExists() throws Exception {
        //Given
        when(buildService.findById(GENERIC_ID)).thenThrow(BuildException.entityNotFound(GENERIC_ID));

        //When Then
        mockMvc.perform(get("/builds/" + GENERIC_ID))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString(Build.class.getSimpleName() + " not found : " + GENERIC_ID)));
    }
}
