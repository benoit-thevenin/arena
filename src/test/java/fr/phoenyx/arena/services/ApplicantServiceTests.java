package fr.phoenyx.arena.services;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static fr.phoenyx.arena.constants.MessagesConstants.*;
import fr.phoenyx.arena.dtos.ApplicantDTO;
import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.Applicant;
import fr.phoenyx.arena.repositories.ApplicantRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicantServiceTests {

    @Mock
    private ApplicantRepository applicantRepository;

    @InjectMocks
    private ApplicantService applicantService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void findAll_shouldReturnList() {
        //Given
        Applicant applicant = new Applicant();
        applicant.setId(GENERIC_ID);
        List<Applicant> applicants = Arrays.asList(applicant);
        when(applicantRepository.findAll()).thenReturn(applicants);

        //When
        List<ApplicantDTO> applicantDTOs = applicantService.findAll();

        //Then
        assertThat(applicantDTOs).hasSize(applicants.size());
    }

    @Test
    public void findById_shouldReturnApplicant_whenExists() {
        //Given
        Applicant applicant = new Applicant();
        applicant.setId(GENERIC_ID);
        when(applicantRepository.findById(GENERIC_ID)).thenReturn(Optional.of(applicant));

        //When
        ApplicantDTO applicantDTO = applicantService.findById(GENERIC_ID);

        //Then
        assertThat(applicantDTO).isNotNull();
        assertThat(applicantDTO.getId()).isEqualTo(GENERIC_ID);
    }

    @Test
    public void findById_shouldThrowException_whenNotExists() {
        //Given
        exceptionRule.expect(GenericEntityException.class);
        String message = String.join(" ", Applicant.class.getSimpleName(), NOT_FOUND, Long.toString(GENERIC_ID));
        exceptionRule.expectMessage(message);
        when(applicantRepository.findById(GENERIC_ID)).thenReturn(Optional.empty());

        //When Then
        applicantService.findById(GENERIC_ID);
    }
}
