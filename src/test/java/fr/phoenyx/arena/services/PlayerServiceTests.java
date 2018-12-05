package fr.phoenyx.arena.services;

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

import fr.phoenyx.arena.dtos.PlayerDTO;
import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.repositories.PlayerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerServiceTests {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void findAll_shouldReturnList() {
        //Given
        Player player = new Player();
        player.setId(GENERIC_ID);
        List<Player> players = Arrays.asList(player);
        when(playerRepository.findAll()).thenReturn(players);

        //When
        List<PlayerDTO> playerDTOs = playerService.findAll();

        //Then
        assertThat(playerDTOs).hasSize(players.size());
    }

    @Test
    public void findById_shouldReturnPlayer_whenExists() {
        //Given
        Player player = new Player();
        player.setId(GENERIC_ID);
        when(playerRepository.findById(GENERIC_ID)).thenReturn(Optional.of(player));

        //When
        PlayerDTO playerDTO = playerService.findById(GENERIC_ID);

        //Then
        assertThat(playerDTO).isNotNull();
        assertThat(playerDTO.getId()).isEqualTo(GENERIC_ID);
    }

    @Test
    public void findById_shouldThrowException_whenNotExists() {
        //Given
        exceptionRule.expect(GenericEntityException.class);
        String message = String.join(" ", Player.class.getSimpleName(), NOT_FOUND, Long.toString(GENERIC_ID));
        exceptionRule.expectMessage(message);
        when(playerRepository.findById(GENERIC_ID)).thenReturn(Optional.empty());

        //When Then
        playerService.findById(GENERIC_ID);
    }
}
