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

import fr.phoenyx.arena.builders.PlayerBuilder;
import fr.phoenyx.arena.dtos.PlayerDTO;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.repositories.PlayerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerServiceTests extends CrudServiceTests<Player, Long, PlayerDTO> {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @Override
    protected JpaRepository<Player, Long> getRepository() {
        return playerRepository;
    }

    @Override
    protected CrudService<Player, Long, PlayerDTO> getService() {
        return playerService;
    }

    @Override
    protected Class<Player> getConcernedClass() {
        return Player.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected Player buildEntity() {
        return new PlayerBuilder().id(GENERIC_ID).build();
    }

    @Override
    protected List<Player> buildEntities() {
        return Arrays.asList(buildEntity());
    }
}
