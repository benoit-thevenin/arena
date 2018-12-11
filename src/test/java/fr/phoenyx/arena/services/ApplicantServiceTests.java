package fr.phoenyx.arena.services;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import fr.phoenyx.arena.builders.ApplicantBuilder;
import fr.phoenyx.arena.dtos.ApplicantDTO;
import fr.phoenyx.arena.models.Applicant;
import fr.phoenyx.arena.repositories.ApplicantRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicantServiceTests extends CrudServiceTests<Applicant, Long, ApplicantDTO> {

    @Mock
    private ApplicantRepository applicantRepository;

    @InjectMocks
    private ApplicantService applicantService;

    @Override
    protected JpaRepository<Applicant, Long> getRepository() {
        return applicantRepository;
    }

    @Override
    protected CrudService<Applicant, Long, ApplicantDTO> getService() {
        return applicantService;
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
    protected Applicant buildEntity() {
        return new ApplicantBuilder().id(GENERIC_ID).build();
    }

    @Override
    protected List<Applicant> buildEntities() {
        return Arrays.asList(buildEntity());
    }
}
