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

import fr.phoenyx.arena.dtos.TeamDTO;
import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.Team;
import fr.phoenyx.arena.repositories.TeamRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamServiceTests {

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamService teamService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void findAll_shouldReturnList() {
        //Given
        Team team = new Team();
        team.setId(GENERIC_ID);
        List<Team> teams = Arrays.asList(team);
        when(teamRepository.findAll()).thenReturn(teams);

        //When
        List<TeamDTO> teamDTOs = teamService.findAll();

        //Then
        assertThat(teamDTOs).hasSize(teams.size());
    }

    @Test
    public void findById_shouldReturnTeam_whenExists() {
        //Given
        Team team = new Team();
        team.setId(GENERIC_ID);
        when(teamRepository.findById(GENERIC_ID)).thenReturn(Optional.of(team));

        //When
        TeamDTO teamDTO = teamService.findById(GENERIC_ID);

        //Then
        assertThat(teamDTO).isNotNull();
        assertThat(teamDTO.getId()).isEqualTo(GENERIC_ID);
    }

    @Test
    public void findById_shouldThrowException_whenNotExists() {
        //Given
        exceptionRule.expect(GenericEntityException.class);
        String message = String.join(" ", Team.class.getSimpleName(), NOT_FOUND, Long.toString(GENERIC_ID));
        exceptionRule.expectMessage(message);
        when(teamRepository.findById(GENERIC_ID)).thenReturn(Optional.empty());

        //When Then
        teamService.findById(GENERIC_ID);
    }
}
