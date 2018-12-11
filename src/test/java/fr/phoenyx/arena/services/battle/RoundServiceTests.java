package fr.phoenyx.arena.services.battle;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import fr.phoenyx.arena.builders.battle.RoundBuilder;
import fr.phoenyx.arena.dtos.battle.RoundDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.battle.RoundMapper;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.models.battle.Action;
import fr.phoenyx.arena.models.battle.Hero;
import fr.phoenyx.arena.models.battle.Round;
import fr.phoenyx.arena.repositories.battle.RoundRepository;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.CrudServiceTests;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoundServiceTests extends CrudServiceTests<Round, Long, RoundDTO> {

    @Mock
    private RoundRepository roundRepository;

    @InjectMocks
    private RoundService roundService;

    @Override
    protected JpaRepository<Round, Long> getRepository() {
        return roundRepository;
    }

    @Override
    protected CrudService<Round, Long, RoundDTO> getService() {
        return roundService;
    }

    @Override
    protected Mapper<Round, RoundDTO> getMapper() {
        return new RoundMapper();
    }

    @Override
    protected Class<Round> getConcernedClass() {
        return Round.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected Round buildEntity() {
        return new RoundBuilder()
                .roundNumber(0)
                .actionsPerformed(new HashSet<>(Arrays.asList(mock(Action.class))))
                .heroes(new HashSet<>(Arrays.asList(mock(Hero.class))))
                .id(GENERIC_ID)
                .dateCreation(LocalDateTime.now())
                .dateModification(LocalDateTime.now())
                .modifier(mock(Player.class)).build();
    }

    @Override
    protected List<Round> buildEntities() {
        return Arrays.asList(buildEntity());
    }
}
