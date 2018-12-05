package fr.phoenyx.arena.services.item;

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

import fr.phoenyx.arena.dtos.item.BonusDTO;
import fr.phoenyx.arena.enums.Characteristic;
import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.item.Bonus;
import fr.phoenyx.arena.repositories.item.BonusRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BonusServiceTests {

    @Mock
    private BonusRepository bonusRepository;

    @InjectMocks
    private BonusService bonusService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void findAll_shouldReturnList() {
        //Given
        Bonus bonus = new Bonus();
        bonus.setId(GENERIC_ID);
        bonus.setCharacteristic(Characteristic.VITALITY);
        List<Bonus> bonuses = Arrays.asList(bonus);
        when(bonusRepository.findAll()).thenReturn(bonuses);

        //When
        List<BonusDTO> bonusDTOs = bonusService.findAll();

        //Then
        assertThat(bonusDTOs).hasSize(bonuses.size());
    }

    @Test
    public void findById_shouldReturnBonus_whenExists() {
        //Given
        Bonus bonus = new Bonus();
        bonus.setId(GENERIC_ID);
        bonus.setCharacteristic(Characteristic.VITALITY);
        when(bonusRepository.findById(GENERIC_ID)).thenReturn(Optional.of(bonus));

        //When
        BonusDTO bonusDTO = bonusService.findById(GENERIC_ID);

        //Then
        assertThat(bonusDTO).isNotNull();
        assertThat(bonusDTO.getId()).isEqualTo(GENERIC_ID);
    }

    @Test
    public void findById_shouldThrowException_whenNotExists() {
        //Given
        exceptionRule.expect(GenericEntityException.class);
        String message = String.join(" ", Bonus.class.getSimpleName(), NOT_FOUND, Long.toString(GENERIC_ID));
        exceptionRule.expectMessage(message);
        when(bonusRepository.findById(GENERIC_ID)).thenReturn(Optional.empty());

        //When Then
        bonusService.findById(GENERIC_ID);
    }
}
