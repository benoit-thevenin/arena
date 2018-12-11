package fr.phoenyx.arena.services.battle;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

import fr.phoenyx.arena.builders.battle.ActionBuilder;
import fr.phoenyx.arena.dtos.battle.ActionDTO;
import fr.phoenyx.arena.enums.skill.ActiveSkillEnum;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.battle.ActionMapper;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.models.battle.Action;
import fr.phoenyx.arena.models.battle.Hero;
import fr.phoenyx.arena.models.skill.ActiveSkill;
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
    protected Mapper<Action, ActionDTO> getMapper() {
        return new ActionMapper();
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
        ActiveSkill activeSkill = mock(ActiveSkill.class);
        when(activeSkill.getActiveSkillEnum()).thenReturn(ActiveSkillEnum.values()[0]);
        return new ActionBuilder()
                .actionOrder(0)
                .caster(mock(Hero.class))
                .skill(activeSkill)
                .targets(new HashSet<>(Arrays.asList(mock(Hero.class))))
                .rand(1.0)
                .id(GENERIC_ID)
                .dateCreation(LocalDateTime.now())
                .dateModification(LocalDateTime.now())
                .modifier(mock(Player.class)).build();
    }

    @Override
    protected List<Action> buildEntities() {
        return Arrays.asList(buildEntity());
    }
}
