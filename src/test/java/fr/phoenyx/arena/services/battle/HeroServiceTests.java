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

import fr.phoenyx.arena.dtos.battle.HeroDTO;
import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.battle.Hero;
import fr.phoenyx.arena.repositories.battle.HeroRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeroServiceTests {

    @Mock
    private HeroRepository heroRepository;

    @InjectMocks
    private HeroService heroService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void findAll_shouldReturnList() {
        //Given
        Hero hero = new Hero();
        hero.setId(GENERIC_ID);
        List<Hero> heroes = Arrays.asList(hero);
        when(heroRepository.findAll()).thenReturn(heroes);

        //When
        List<HeroDTO> heroDTOs = heroService.findAll();

        //Then
        assertThat(heroDTOs).hasSize(heroes.size());
    }

    @Test
    public void findById_shouldReturnHero_whenExists() {
        //Given
        Hero hero = new Hero();
        hero.setId(GENERIC_ID);
        when(heroRepository.findById(GENERIC_ID)).thenReturn(Optional.of(hero));

        //When
        HeroDTO heroDTO = heroService.findById(GENERIC_ID);

        //Then
        assertThat(heroDTO).isNotNull();
        assertThat(heroDTO.getId()).isEqualTo(GENERIC_ID);
    }

    @Test
    public void findById_shouldThrowException_whenNotExists() {
        //Given
        exceptionRule.expect(GenericEntityException.class);
        String message = String.join(" ", Hero.class.getSimpleName(), NOT_FOUND, Long.toString(GENERIC_ID));
        exceptionRule.expectMessage(message);
        when(heroRepository.findById(GENERIC_ID)).thenReturn(Optional.empty());

        //When Then
        heroService.findById(GENERIC_ID);
    }
}
