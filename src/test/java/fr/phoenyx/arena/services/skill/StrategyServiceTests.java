package fr.phoenyx.arena.services.skill;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import fr.phoenyx.arena.builders.skill.StrategyBuilder;
import fr.phoenyx.arena.dtos.skill.StrategyDTO;
import fr.phoenyx.arena.models.skill.Strategy;
import fr.phoenyx.arena.repositories.skill.StrategyRepository;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.CrudServiceTests;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyServiceTests extends CrudServiceTests<Strategy, Long, StrategyDTO> {

    @Mock
    private StrategyRepository strategyRepository;

    @InjectMocks
    private StrategyService strategyService;

    @Override
    protected JpaRepository<Strategy, Long> getRepository() {
        return strategyRepository;
    }

    @Override
    protected CrudService<Strategy, Long, StrategyDTO> getService() {
        return strategyService;
    }

    @Override
    protected Class<Strategy> getConcernedClass() {
        return Strategy.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected Strategy buildEntity() {
        return new StrategyBuilder().id(GENERIC_ID).build();
    }

    @Override
    protected List<Strategy> buildEntities() {
        return Arrays.asList(buildEntity());
    }
}
