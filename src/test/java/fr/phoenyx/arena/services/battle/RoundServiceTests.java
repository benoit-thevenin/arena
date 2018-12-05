package fr.phoenyx.arena.services.battle;

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

import fr.phoenyx.arena.dtos.battle.RoundDTO;
import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.battle.Round;
import fr.phoenyx.arena.repositories.battle.RoundRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoundServiceTests {

    @Mock
    private RoundRepository roundRepository;

    @InjectMocks
    private RoundService roundService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void findAll_shouldReturnList() {
        //Given
        Round round = new Round();
        round.setId(GENERIC_ID);
        List<Round> rounds = Arrays.asList(round);
        when(roundRepository.findAll()).thenReturn(rounds);

        //When
        List<RoundDTO> roundDTOs = roundService.findAll();

        //Then
        assertThat(roundDTOs).hasSize(rounds.size());
    }

    @Test
    public void findById_shouldReturnRound_whenExists() {
        //Given
        Round round = new Round();
        round.setId(GENERIC_ID);
        when(roundRepository.findById(GENERIC_ID)).thenReturn(Optional.of(round));

        //When
        RoundDTO roundDTO = roundService.findById(GENERIC_ID);

        //Then
        assertThat(roundDTO).isNotNull();
        assertThat(roundDTO.getId()).isEqualTo(GENERIC_ID);
    }

    @Test
    public void findById_shouldThrowException_whenNotExists() {
        //Given
        exceptionRule.expect(GenericEntityException.class);
        String message = String.join(" ", Round.class.getSimpleName(), NOT_FOUND, Long.toString(GENERIC_ID));
        exceptionRule.expectMessage(message);
        when(roundRepository.findById(GENERIC_ID)).thenReturn(Optional.empty());

        //When Then
        roundService.findById(GENERIC_ID);
    }
}
