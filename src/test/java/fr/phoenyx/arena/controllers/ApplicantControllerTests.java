package fr.phoenyx.arena.controllers;

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

import fr.phoenyx.arena.advices.ApplicantAdvice;
import fr.phoenyx.arena.advices.GenericAdvice;
import fr.phoenyx.arena.advices.GenericEntityAdvice;
import fr.phoenyx.arena.dtos.ApplicantDTO;
import fr.phoenyx.arena.exceptions.ApplicantException;
import fr.phoenyx.arena.models.Applicant;
import fr.phoenyx.arena.services.ApplicantService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicantControllerTests {

    private static final long ID = 0L;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ApplicantService applicantService;

    @InjectMocks
    private ApplicantController applicantController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(applicantController)
                .setControllerAdvice(new GenericAdvice(), new GenericEntityAdvice(), new ApplicantAdvice())
                .build();
    }

    @Test
    public void findAll_shouldReturnOK() throws Exception {
        mockMvc.perform(get("/applicants"))
                .andExpect(status().isOk());
    }

    @Test
    public void findById_shouldReturnOK_whenExists() throws Exception {
        //Given
        ApplicantDTO applicant = new ApplicantDTO();
        applicant.setId(ID);
        when(applicantService.findById(ID)).thenReturn(applicant);

        //When Then
        mockMvc.perform(get("/applicants/" + ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(Long.toString(ID))));
    }

    @Test
    public void findById_shouldReturnNotFound_whenNotExists() throws Exception {
        //Given
        when(applicantService.findById(ID)).thenThrow(ApplicantException.entityNotFound(ID));

        //When Then
        mockMvc.perform(get("/applicants/" + ID))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString(Applicant.class.getSimpleName() + " not found : " + ID)));
    }
}
