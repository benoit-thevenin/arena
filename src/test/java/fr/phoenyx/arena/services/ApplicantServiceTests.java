package fr.phoenyx.arena.services;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import fr.phoenyx.arena.builders.ApplicantBuilder;
import fr.phoenyx.arena.dtos.ApplicantDTO;
import fr.phoenyx.arena.exceptions.BadRequestException;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.mappers.ApplicantMapper;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.Applicant;
import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.repositories.ApplicantRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicantServiceTests extends CrudServiceTests<Applicant, ApplicantDTO> {

    @Mock
    private ApplicantRepository applicantRepository;

    @InjectMocks
    private ApplicantService applicantService;

    @Override
    protected JpaRepository<Applicant, Long> getRepository() {
        return applicantRepository;
    }

    @Override
    protected CrudService<Applicant, ApplicantDTO> getService() {
        return applicantService;
    }

    @Override
    protected Mapper<Applicant, ApplicantDTO> getMapper() {
        return new ApplicantMapper();
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
        return new ApplicantBuilder()
                .build(mock(Build.class))
                .player(mock(Player.class))
                .id(GENERIC_ID)
                .dateCreation(LocalDateTime.now())
                .dateModification(LocalDateTime.now())
                .modifier(mock(Player.class)).build();
    }

    @Override
    protected List<Applicant> buildEntities() {
        return Arrays.asList(buildEntity());
    }

    @Override
    @Test
    public void create_shouldReturnDTO_whenOK() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    @Test
    public void create_shouldThrowNotFoundException_whenNotExists() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    @Test
    public void create_shouldThrowBadRequestException_whenKO() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    @Test
    public void update_shouldReturnDTO_whenOK() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    @Test
    public void update_shouldThrowNotFoundException_whenNotExists() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    @Test
    public void update_shouldThrowBadRequestException_whenKO() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }
}
