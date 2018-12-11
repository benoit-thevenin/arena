package fr.phoenyx.arena.services.guild;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import fr.phoenyx.arena.builders.guild.GuildBuilder;
import fr.phoenyx.arena.dtos.guild.GuildDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.guild.GuildMapper;
import fr.phoenyx.arena.models.Applicant;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.models.guild.Guild;
import fr.phoenyx.arena.repositories.guild.GuildRepository;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.CrudServiceTests;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuildServiceTests extends CrudServiceTests<Guild, Long, GuildDTO> {

    @Mock
    private GuildRepository guildRepository;

    @InjectMocks
    private GuildService guildService;

    @Override
    protected JpaRepository<Guild, Long> getRepository() {
        return guildRepository;
    }

    @Override
    protected CrudService<Guild, Long, GuildDTO> getService() {
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
                .members(Arrays.asList(mock(Player.class)))
                .applicants(Arrays.asList(mock(Applicant.class)))
                .id(GENERIC_ID)
                .dateCreation(LocalDateTime.now())
                .dateModification(LocalDateTime.now())
                .modifier(mock(Player.class)).build();
    }

    @Override
    protected List<Guild> buildEntities() {
        return Arrays.asList(buildEntity());
    }
}
