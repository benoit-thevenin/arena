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

import fr.phoenyx.arena.dtos.BuildDTO;
import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.repositories.BuildRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuildServiceTests {

    @Mock
    private BuildRepository buildRepository;

    @InjectMocks
    private BuildService buildService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void findAll_shouldReturnList() {
        //Given
        Build build = new Build();
        build.setId(GENERIC_ID);
        List<Build> builds = Arrays.asList(build);
        when(buildRepository.findAll()).thenReturn(builds);

        //When
        List<BuildDTO> buildDTOs = buildService.findAll();

        //Then
        assertThat(buildDTOs).hasSize(builds.size());
    }

    @Test
    public void findById_shouldReturnBuild_whenExists() {
        //Given
        Build build = new Build();
        build.setId(GENERIC_ID);
        when(buildRepository.findById(GENERIC_ID)).thenReturn(Optional.of(build));

        //When
        BuildDTO buildDTO = buildService.findById(GENERIC_ID);

        //Then
        assertThat(buildDTO).isNotNull();
        assertThat(buildDTO.getId()).isEqualTo(GENERIC_ID);
    }

    @Test
    public void findById_shouldThrowException_whenNotExists() {
        //Given
        exceptionRule.expect(GenericEntityException.class);
        String message = String.join(" ", Build.class.getSimpleName(), NOT_FOUND, Long.toString(GENERIC_ID));
        exceptionRule.expectMessage(message);
        when(buildRepository.findById(GENERIC_ID)).thenReturn(Optional.empty());

        //When Then
        buildService.findById(GENERIC_ID);
    }
}
