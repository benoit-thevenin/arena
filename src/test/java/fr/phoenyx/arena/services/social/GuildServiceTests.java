package fr.phoenyx.arena.services.social;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import fr.phoenyx.arena.builders.social.GuildBuilder;
import fr.phoenyx.arena.dtos.social.GuildDTO;
import fr.phoenyx.arena.exceptions.BadRequestException;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.social.GuildMapper;
import fr.phoenyx.arena.models.social.Applicant;
import fr.phoenyx.arena.models.social.Guild;
import fr.phoenyx.arena.models.social.Player;
import fr.phoenyx.arena.repositories.social.GuildRepository;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.CrudServiceTests;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuildServiceTests extends CrudServiceTests<Guild, GuildDTO> {

    @Mock
    private GuildRepository guildRepository;

    @InjectMocks
    private GuildService guildService;

    @Override
    protected JpaRepository<Guild, Long> getRepository() {
        return guildRepository;
    }

    @Override
    protected CrudService<Guild, GuildDTO> getService() {
        return guildService;
    }

    @Override
    protected Mapper<Guild, GuildDTO> getMapper() {
        return new GuildMapper();
    }

    @Override
    protected Class<Guild> getConcernedClass() {
        return Guild.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected Guild buildEntity() {
        return new GuildBuilder()
                .name("name")
                .description("description")
                .members(new HashSet<>(Arrays.asList(mock(Player.class))))
                .applicants(new HashSet<>(Arrays.asList(mock(Applicant.class))))
                .id(GENERIC_ID)
                .dateCreation(LocalDateTime.now())
                .dateModification(LocalDateTime.now())
                .modifier(mock(Player.class)).build();
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
