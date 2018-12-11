package fr.phoenyx.arena.controllers;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import fr.phoenyx.arena.advices.BadRequestAdvice;
import fr.phoenyx.arena.advices.EntityNotFoundAdvice;
import fr.phoenyx.arena.advices.GenericAdvice;
import fr.phoenyx.arena.builders.ApplicantBuilder;
import fr.phoenyx.arena.dtos.ApplicantDTO;
import fr.phoenyx.arena.models.Applicant;
import fr.phoenyx.arena.services.ApplicantService;
import fr.phoenyx.arena.services.CrudService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicantControllerTests extends CrudControllerTests<Applicant, Long, ApplicantDTO> {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ApplicantService applicantService;

    @InjectMocks
    private ApplicantController applicantController;

    @Override
    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    protected CrudService<Applicant, Long, ApplicantDTO> getService() {
        return applicantService;
    }

    @Override
    protected String getEndpointRoot() {
        return "/applicants";
    }

    @Override
    protected Class<Applicant> getConcernedClass() {
        return Applicant.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected ApplicantDTO buildDTO() {
        Applicant applicant = new ApplicantBuilder()
                .id(GENERIC_ID).build();
        return new ApplicantDTO(applicant);
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(applicantController)
                .setControllerAdvice(new GenericAdvice(), new EntityNotFoundAdvice(), new BadRequestAdvice())
                .build();
    }
}
