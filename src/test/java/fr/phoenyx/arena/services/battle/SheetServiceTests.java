package fr.phoenyx.arena.services.battle;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import fr.phoenyx.arena.builders.battle.SheetBuilder;
import fr.phoenyx.arena.dtos.battle.SheetDTO;
import fr.phoenyx.arena.enums.skill.Effect;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.battle.SheetMapper;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.models.battle.Hero;
import fr.phoenyx.arena.models.battle.Sheet;
import fr.phoenyx.arena.repositories.battle.SheetRepository;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.CrudServiceTests;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SheetServiceTests extends CrudServiceTests<Sheet, Long, SheetDTO> {

    @Mock
    private SheetRepository sheetRepository;

    @InjectMocks
    private SheetService sheetService;

    @Override
    protected JpaRepository<Sheet, Long> getRepository() {
        return sheetRepository;
    }

    @Override
    protected CrudService<Sheet, Long, SheetDTO> getService() {
        return sheetService;
    }

    @Override
    protected Mapper<Sheet, SheetDTO> getMapper() {
        return new SheetMapper();
    }

    @Override
    protected Class<Sheet> getConcernedClass() {
        return Sheet.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected Sheet buildEntity() {
        return new SheetBuilder()
                .hero(mock(Hero.class))
                .initHealth(0)
                .initMana(0)
                .strength(0)
                .agility(0)
                .intelligence(0)
                .currentHealth(0)
                .currentMana(0)
                .effects(Arrays.asList(Effect.values()[0]))
                .id(GENERIC_ID)
                .dateCreation(LocalDateTime.now())
                .dateModification(LocalDateTime.now())
                .modifier(mock(Player.class)).build();
    }

    @Override
    protected List<Sheet> buildEntities() {
        return Arrays.asList(buildEntity());
    }
}
