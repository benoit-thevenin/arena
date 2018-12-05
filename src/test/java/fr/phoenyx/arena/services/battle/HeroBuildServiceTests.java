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

import fr.phoenyx.arena.dtos.battle.HeroBuildDTO;
import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.battle.HeroBuild;
import fr.phoenyx.arena.repositories.battle.HeroBuildRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeroBuildServiceTests {

    @Mock
    private HeroBuildRepository heroBuildRepository;

    @InjectMocks
    private HeroBuildService heroBuildService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void findAll_shouldReturnList() {
        //Given
        HeroBuild heroBuild = new HeroBuild();
        heroBuild.setId(GENERIC_ID);
        List<HeroBuild> heroBuilds = Arrays.asList(heroBuild);
        when(heroBuildRepository.findAll()).thenReturn(heroBuilds);

        //When
        List<HeroBuildDTO> heroBuildDTOs = heroBuildService.findAll();

        //Then
        assertThat(heroBuildDTOs).hasSize(heroBuilds.size());
    }

    @Test
    public void findById_shouldReturnHeroBuild_whenExists() {
        //Given
        HeroBuild heroBuild = new HeroBuild();
        heroBuild.setId(GENERIC_ID);
        when(heroBuildRepository.findById(GENERIC_ID)).thenReturn(Optional.of(heroBuild));

        //When
        HeroBuildDTO heroBuildDTO = heroBuildService.findById(GENERIC_ID);

        //Then
        assertThat(heroBuildDTO).isNotNull();
        assertThat(heroBuildDTO.getId()).isEqualTo(GENERIC_ID);
    }

    @Test
    public void findById_shouldThrowException_whenNotExists() {
        //Given
        exceptionRule.expect(GenericEntityException.class);
        String message = String.join(" ", HeroBuild.class.getSimpleName(), NOT_FOUND, Long.toString(GENERIC_ID));
        exceptionRule.expectMessage(message);
        when(heroBuildRepository.findById(GENERIC_ID)).thenReturn(Optional.empty());

        //When Then
        heroBuildService.findById(GENERIC_ID);
    }
}
