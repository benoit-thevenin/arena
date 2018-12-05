package fr.phoenyx.arena.services.guild;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static fr.phoenyx.arena.constants.MessagesConstants.NOT_FOUND;
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

import fr.phoenyx.arena.dtos.guild.GuildDTO;
import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.guild.Guild;
import fr.phoenyx.arena.repositories.guild.GuildRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuildServiceTests {

    @Mock
    private GuildRepository guildRepository;

    @InjectMocks
    private GuildService guildService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void findAll_shouldReturnList() {
        //Given
        Guild guild = new Guild();
        guild.setId(GENERIC_ID);
        List<Guild> guilds = Arrays.asList(guild);
        when(guildRepository.findAll()).thenReturn(guilds);

        //When
        List<GuildDTO> guildDTOs = guildService.findAll();

        //Then
        assertThat(guildDTOs).hasSize(guilds.size());
    }

    @Test
    public void findById_shouldReturnGuild_whenExists() {
        //Given
        Guild guild = new Guild();
        guild.setId(GENERIC_ID);
        when(guildRepository.findById(GENERIC_ID)).thenReturn(Optional.of(guild));

        //When
        GuildDTO guildDTO = guildService.findById(GENERIC_ID);

        //Then
        assertThat(guildDTO).isNotNull();
        assertThat(guildDTO.getId()).isEqualTo(GENERIC_ID);
    }

    @Test
    public void findById_shouldThrowException_whenNotExists() {
        //Given
        exceptionRule.expect(GenericEntityException.class);
        String message = String.join(" ", Guild.class.getSimpleName(), NOT_FOUND, Long.toString(GENERIC_ID));
        exceptionRule.expectMessage(message);
        when(guildRepository.findById(GENERIC_ID)).thenReturn(Optional.empty());

        //When Then
        guildService.findById(GENERIC_ID);
    }
}
