package fr.phoenyx.arena.services;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import fr.phoenyx.arena.builders.TeamBuilder;
import fr.phoenyx.arena.dtos.TeamDTO;
import fr.phoenyx.arena.models.Team;
import fr.phoenyx.arena.repositories.TeamRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamServiceTests extends CrudServiceTests<Team, Long, TeamDTO> {

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamService teamService;

    @Override
    protected JpaRepository<Team, Long> getRepository() {
        return teamRepository;
    }

    @Override
    protected CrudService<Team, Long, TeamDTO> getService() {
        return teamService;
    }

    @Override
    protected Class<Team> getConcernedClass() {
        return Team.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected Team buildEntity() {
        return new TeamBuilder().id(GENERIC_ID).build();
    }

    @Override
    protected List<Team> buildEntities() {
        return Arrays.asList(buildEntity());
    }
}
