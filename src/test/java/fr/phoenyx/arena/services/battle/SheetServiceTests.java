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

import fr.phoenyx.arena.dtos.battle.SheetDTO;
import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.battle.Sheet;
import fr.phoenyx.arena.repositories.battle.SheetRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SheetServiceTests {

    @Mock
    private SheetRepository sheetRepository;

    @InjectMocks
    private SheetService sheetService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void findAll_shouldReturnList() {
        //Given
        Sheet sheet = new Sheet();
        sheet.setId(GENERIC_ID);
        List<Sheet> sheets = Arrays.asList(sheet);
        when(sheetRepository.findAll()).thenReturn(sheets);

        //When
        List<SheetDTO> sheetDTOs = sheetService.findAll();

        //Then
        assertThat(sheetDTOs).hasSize(sheets.size());
    }

    @Test
    public void findById_shouldReturnSheet_whenExists() {
        //Given
        Sheet sheet = new Sheet();
        sheet.setId(GENERIC_ID);
        when(sheetRepository.findById(GENERIC_ID)).thenReturn(Optional.of(sheet));

        //When
        SheetDTO sheetDTO = sheetService.findById(GENERIC_ID);

        //Then
        assertThat(sheetDTO).isNotNull();
        assertThat(sheetDTO.getId()).isEqualTo(GENERIC_ID);
    }

    @Test
    public void findById_shouldThrowException_whenNotExists() {
        //Given
        exceptionRule.expect(GenericEntityException.class);
        String message = String.join(" ", Sheet.class.getSimpleName(), NOT_FOUND, Long.toString(GENERIC_ID));
        exceptionRule.expectMessage(message);
        when(sheetRepository.findById(GENERIC_ID)).thenReturn(Optional.empty());

        //When Then
        sheetService.findById(GENERIC_ID);
    }
}
