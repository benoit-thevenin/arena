package fr.phoenyx.arena.services.skill;

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

import fr.phoenyx.arena.dtos.skill.StrategyDTO;
import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.skill.Strategy;
import fr.phoenyx.arena.repositories.skill.StrategyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyServiceTests {

    @Mock
    private StrategyRepository strategyRepository;

    @InjectMocks
    private StrategyService strategyService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void findAll_shouldReturnList() {
        //Given
        Strategy strategy = new Strategy();
        strategy.setId(GENERIC_ID);
        List<Strategy> strategies = Arrays.asList(strategy);
        when(strategyRepository.findAll()).thenReturn(strategies);

        //When
        List<StrategyDTO> strategyDTOs = strategyService.findAll();

        //Then
        assertThat(strategyDTOs).hasSize(strategies.size());
    }

    @Test
    public void findById_shouldReturnStrategy_whenExists() {
        //Given
        Strategy strategy = new Strategy();
        strategy.setId(GENERIC_ID);
        when(strategyRepository.findById(GENERIC_ID)).thenReturn(Optional.of(strategy));

        //When
        StrategyDTO strategyDTO = strategyService.findById(GENERIC_ID);

        //Then
        assertThat(strategyDTO).isNotNull();
        assertThat(strategyDTO.getId()).isEqualTo(GENERIC_ID);
    }

    @Test
    public void findById_shouldThrowException_whenNotExists() {
        //Given
        exceptionRule.expect(GenericEntityException.class);
        String message = String.join(" ", Strategy.class.getSimpleName(), NOT_FOUND, Long.toString(GENERIC_ID));
        exceptionRule.expectMessage(message);
        when(strategyRepository.findById(GENERIC_ID)).thenReturn(Optional.empty());

        //When Then
        strategyService.findById(GENERIC_ID);
    }
}
