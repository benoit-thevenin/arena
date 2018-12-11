package fr.phoenyx.arena.services.battle;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import fr.phoenyx.arena.builders.battle.BattleBuilder;
import fr.phoenyx.arena.dtos.battle.BattleDTO;
import fr.phoenyx.arena.models.battle.Battle;
import fr.phoenyx.arena.repositories.battle.BattleRepository;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.CrudServiceTests;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BattleServiceTests extends CrudServiceTests<Battle, Long, BattleDTO> {

    @Mock
    private BattleRepository battleRepository;

    @InjectMocks
    private BattleService battleService;

    @Override
    protected JpaRepository<Battle, Long> getRepository() {
        return battleRepository;
    }

    @Override
    protected CrudService<Battle, Long, BattleDTO> getService() {
        return battleService;
    }

    @Override
    protected Class<Battle> getConcernedClass() {
        return Battle.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected Battle buildEntity() {
        return new BattleBuilder().id(GENERIC_ID).build();
    }

    @Override
    protected List<Battle> buildEntities() {
        return Arrays.asList(buildEntity());
    }
}
