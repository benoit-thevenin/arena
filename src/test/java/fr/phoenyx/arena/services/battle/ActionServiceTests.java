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

import fr.phoenyx.arena.builders.battle.ActionBuilder;
import fr.phoenyx.arena.dtos.battle.ActionDTO;
import fr.phoenyx.arena.models.battle.Action;
import fr.phoenyx.arena.repositories.battle.ActionRepository;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.CrudServiceTests;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActionServiceTests extends CrudServiceTests<Action, Long, ActionDTO> {

    @Mock
    private ActionRepository actionRepository;

    @InjectMocks
    private ActionService actionService;

    @Override
    protected JpaRepository<Action, Long> getRepository() {
        return actionRepository;
    }

    @Override
    protected CrudService<Action, Long, ActionDTO> getService() {
        return actionService;
    }

    @Override
    protected Class<Action> getConcernedClass() {
        return Action.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected Action buildEntity() {
        return new ActionBuilder().id(GENERIC_ID).build();
    }

    @Override
    protected List<Action> buildEntities() {
        return Arrays.asList(buildEntity());
    }
}
