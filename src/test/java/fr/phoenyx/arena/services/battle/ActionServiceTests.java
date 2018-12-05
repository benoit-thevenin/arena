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

import fr.phoenyx.arena.dtos.battle.ActionDTO;
import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.battle.Action;
import fr.phoenyx.arena.repositories.battle.ActionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActionServiceTests {

    @Mock
    private ActionRepository actionRepository;

    @InjectMocks
    private ActionService actionService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void findAll_shouldReturnList() {
        //Given
        Action action = new Action();
        action.setId(GENERIC_ID);
        List<Action> actions = Arrays.asList(action);
        when(actionRepository.findAll()).thenReturn(actions);

        //When
        List<ActionDTO> actionDTOs = actionService.findAll();

        //Then
        assertThat(actionDTOs).hasSize(actions.size());
    }

    @Test
    public void findById_shouldReturnAction_whenExists() {
        //Given
        Action action = new Action();
        action.setId(GENERIC_ID);
        when(actionRepository.findById(GENERIC_ID)).thenReturn(Optional.of(action));

        //When
        ActionDTO actionDTO = actionService.findById(GENERIC_ID);

        //Then
        assertThat(actionDTO).isNotNull();
        assertThat(actionDTO.getId()).isEqualTo(GENERIC_ID);
    }

    @Test
    public void findById_shouldThrowException_whenNotExists() {
        //Given
        exceptionRule.expect(GenericEntityException.class);
        String message = String.join(" ", Action.class.getSimpleName(), NOT_FOUND, Long.toString(GENERIC_ID));
        exceptionRule.expectMessage(message);
        when(actionRepository.findById(GENERIC_ID)).thenReturn(Optional.empty());

        //When Then
        actionService.findById(GENERIC_ID);
    }
}
